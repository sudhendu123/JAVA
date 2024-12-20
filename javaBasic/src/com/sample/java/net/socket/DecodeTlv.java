package com.sample.java.net.socket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DecodeTlv {
	
	
	public static KnPoCXLATableDetailsDTO decodeTlv(KnTLVMsgRespDTO respDto) {
        final String methodName = "decodeTlv";
        HashMap<Integer, KnTLVValueObject> decodedMap;
        decodedMap = respDto.getMap();
        Object columnDetailsvalue = new Object();
        Object primaryColumnDetails = new Object();
        int isEncodingFailed = 0;
        String tableName = null;
        ArrayList<Object> columnDetailsArray;
        List<String> primaryColumns = new ArrayList<>();
        KnPoCXLATableDetailsDTO knPoCXLATableDetailsDTO = new KnPoCXLATableDetailsDTO();
        for (Map.Entry<Integer, KnTLVValueObject> entry : decodedMap.entrySet()) {
            switch(entry.getKey()){
                case KnPoCXLAConstants.TLVTAGTYPE_TABLE_NAME :
                    tableName = (String) entry.getValue().getValue();
                    break;
                case KnPoCXLAConstants.TLVTAGTYPE_COLUMN_DETAILS :
                    columnDetailsvalue = entry.getValue().getValue();
                    break;
                case KnPoCXLAConstants.TLVTAGTYPE_PRI_COLUMN :
                    primaryColumnDetails = entry.getValue().getValue();
                    break;
                case KnPoCXLAConstants.TLVTAGTYPE_IS_ENCODING_FAILED:
                    isEncodingFailed = (int) entry.getValue().getValue();
            }
        }
        try {

            if (primaryColumnDetails instanceof List) {
                columnDetailsArray = (ArrayList<Object>) primaryColumnDetails;
                Iterator<Object> iterator = columnDetailsArray.iterator();
                while (iterator.hasNext()) {
                    ArrayList<Map> bulkOrderInfo = (ArrayList<Map>) iterator.next();
                    for (Map<Integer, KnTLVValueObject> bulkOrderInfo1 : bulkOrderInfo) {
                        String columnName = null;
                        for (Map.Entry<Integer, KnTLVValueObject> entry1 : bulkOrderInfo1.entrySet()) {
                            if (entry1.getKey() == KnPoCXLAConstants.TLVTAGTYPE_COLUMN_NAME) {
                                columnName = (String) entry1.getValue().getValue();
                                primaryColumns.add(columnName.trim());
                            }

                        }
                    }
                }
            }
            if (isEncodingFailed == 1) {
                knPoCXLATableDetailsDTO = populateTableDetailsDTO(primaryColumnDetails, primaryColumns);
            } else {
                knPoCXLATableDetailsDTO = populateTableDetailsDTO(columnDetailsvalue, primaryColumns);
            }
            knPoCXLATableDetailsDTO.setTableName(tableName);
            knPoCXLATableDetailsDTO.setEncodingFailed((isEncodingFailed == 1) ? true : false);
        } catch (Exception e) {

        }
        return knPoCXLATableDetailsDTO;

    }
	
	 private static KnPoCXLATableDetailsDTO populateTableDetailsDTO(Object columnDetails, List<String> primaryColumns) {
	        final String methodName = "populateTableDetailsDTO()";
	        ArrayList<Object> columnDetailsArray;
	        KnPoCXLAEventDTO knPoCXLAEventDTO = new KnPoCXLAEventDTO();
	        Map<String, KnPoCXLAEventDTO> columnDetailsMap = new HashMap<>();
	        KnPoCXLATableDetailsDTO knPoCXLATableDetailsDTO = new KnPoCXLATableDetailsDTO();
	        if (columnDetails instanceof List) {
	            columnDetailsArray = (ArrayList<Object>) columnDetails;
	            Iterator<Object> iterator = columnDetailsArray.iterator();
	            while (iterator.hasNext()) {
	                ArrayList<Map> bulkOrderInfo = (ArrayList<Map>) iterator.next();
	                for (Map<Integer, KnTLVValueObject> bulkOrderInfo1 : bulkOrderInfo) {
	                    String columnName = null;
	                    Object columnValue = 0;
	                    Object oldValue = 0;
	                    int isvalueChanged = 0;
	                    boolean isPrimaryKey = false;
	                    for (Map.Entry<Integer, KnTLVValueObject> entry1 : bulkOrderInfo1.entrySet()) {
	                        knPoCXLAEventDTO = new KnPoCXLAEventDTO();
	                        switch(entry1.getKey()){
	                            case KnPoCXLAConstants.TLVTAGTYPE_IS_VALUE_CHANGED:
	                                isvalueChanged = (int) entry1.getValue().getValue();
	                                break;
	                            case KnPoCXLAConstants.TLVTAGTYPE_NEW_INT_VAL:
	                                columnValue = entry1.getValue().getValue();
	                                break;
	                            case KnPoCXLAConstants.TLVTAGTYPE_OLD_INT_VAL:
	                                oldValue = entry1.getValue().getValue();
	                                break;
	                            case KnPoCXLAConstants.TLVTAGTYPE_NEW_LONG_VAL:
	                                columnValue = entry1.getValue().getValue();
	                                break;
	                            case KnPoCXLAConstants.TLVTAGTYPE_OLD_LONG_VAL:
	                                oldValue = entry1.getValue().getValue();
	                                break;
	                            case KnPoCXLAConstants.TLVTAGTYPE_NEW_BUFFER_VAL:
	                                columnValue = entry1.getValue().getValue();
	                                break;
	                            case KnPoCXLAConstants.TLVTAGTYPE_OLD_BUFFER_VAL:
	                                oldValue = entry1.getValue().getValue();
	                                break;
	                            case KnPoCXLAConstants.TLVTAGTYPE_COLUMN_NAME:
	                                columnName = (String) entry1.getValue().getValue();
	                                if (primaryColumns.contains(columnName.trim())) {
	                                    isPrimaryKey = true;
	                                }
	                        }

	                    }
	                    knPoCXLAEventDTO.setIsvalueChanged(isvalueChanged);
	                    knPoCXLAEventDTO.setColumnValue(columnValue);
	                    knPoCXLAEventDTO.setOldValue(oldValue);
	                    knPoCXLAEventDTO.setColumnName(columnName.trim());
	                    knPoCXLAEventDTO.setPrimaryKey(isPrimaryKey);
	                    columnDetailsMap.put(columnName.trim(), knPoCXLAEventDTO);
	                }

	            }
	            knPoCXLATableDetailsDTO.setColumnDetailsMap(columnDetailsMap);
	        }
	        return  knPoCXLATableDetailsDTO;
	    }

}

class KnPoCXLATableDetailsDTO {
    //Contains table name for which event is published
    private String tableName;
    //Flag to indiacte whether TLV encoding failed during XLA event generation
    //If value is 1 - the application has to fetch the row values of the table using the primary key values in the columnDetailsMap.
    //If value is 0 - the columnDetailsMap contains the updated row data, No need to dip into database.
    private boolean isEncodingFailed;
    //Map contains column name - value pairs
    private Map<String, KnPoCXLAEventDTO> columnDetailsMap;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, KnPoCXLAEventDTO> getColumnDetailsMap() {
        return columnDetailsMap;
    }

    public void setColumnDetailsMap(Map<String, KnPoCXLAEventDTO> columnDetailsMap) {
        this.columnDetailsMap = columnDetailsMap;
    }

    public boolean isEncodingFailed() {
        return isEncodingFailed;
    }

    public void setEncodingFailed(boolean isEncodingFailed) {
        this.isEncodingFailed = isEncodingFailed;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("KnPoCXLATableDetailsDTO [tableName=").append(tableName).append(", isEncodingFailed=").append(isEncodingFailed).append(", columnDetailsMap=").append(columnDetailsMap).append("]");
        return builder.toString();
    }
}

class KnPoCXLAEventDTO {

    //Flag to indicate column value changed or not, 1- Changed , 0- not Changed
    private int isvalueChanged;
    //contains the column name
    private String columnName;
    //Flag to indicate the column is primary key, 1 -Cloumn is primary key, 0-Cloumn is not a primary key
    private boolean isPrimaryKey;
    // value of the column after the row update
    //The columnValue is a object type, So appliaction has to decide value type in the object based on column datatype.
    //If the clolun is integer Datatype then type cast the columnValue to integer. int intValue = (int) getColumnValue()
    //If the clolun is Varchar Datatype then read the columnValue as stream and type cast it . String stringValue = new String(byte[] getColumnValue())
    //If the clolun is TimeStamp Datatypethen get the columnValue as toString and type cast it . Long longValue = new Long(getColumnValue().toString())
    private Object columnValue;
    //Value of the column before the row update
    //The columnValue is a object type, So appliaction has to decide value type in the object based on column datatype.
    //If the clolun is integer Datatype then type cast the columnValue to integer. int intValue = (int) getColumnValue()
    //If the clolun is Varchar Datatype then read the columnValue as stream and type cast it . String stringValue = new String(byte[] getColumnValue())
    //If the clolun is TimeStamp Datatype then get the columnValue as toString and type cast it . Long longValue = new Long(getColumnValue().toString())
    private Object oldValue;

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }


    public Object getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(Object columnValue) {
        this.columnValue = columnValue;
    }

    public int getIsvalueChanged() {
        return isvalueChanged;
    }

    public void setIsvalueChanged(int isvalueChanged) {
        this.isvalueChanged = isvalueChanged;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("KnPoCXLAEventDTO [columnName=").append(columnName)
                .append(", isPrimaryKey=").append(isPrimaryKey)
                .append(", columnValue=").append(columnValue)
                .append(", oldValue=").append(oldValue)
                .append(", isvalueChanged=").append(isvalueChanged)
                .append("]");
        return builder.toString();
    }
}

class KnPoCXLAConstants {
    //TLV message ID's
    public static final int POC_XLA_HANDLER_REGISTER_TABLE = 1;
    public static final int POC_XLA_HANDLER_UNREGISTER_TABLE = 2;
    public static final int POC_XLA_HANDLER_INSERT_XLA_MSG = 3;
    public static final int POC_XLA_HANDLER_DELETE_XLA_MSG = 4;
    public static final int POC_XLA_HANDLER_UPDATE_XLA_MSG = 5;

    //TLV Message Protocol Version
    public static final int VERSION = 2;

    //XLA response TLV message Tag ID's
    public static final int TLVTAGTYPE_TABLE_NAME = 1;
    public static final int TLVTAGTYPE_PRI_COLUMN = 2;
    public static final int TLVTAGTYPE_COLUMN_DETAILS = 3;
    public static final int TLVTAGTYPE_IS_ENCODING_FAILED = 4;

    //TAble Details TLV message Tag ID's
    public static final int TLVTAGTYPE_COLUMN_NAME = 1;
    public static final int TLVTAGTYPE_DATA_TYPE = 2;
    public static final int TLVTAGTYPE_PRIMARY_COLUMN_LIST = 3;
    public static final int TLVTAGTYPE_NEW_INT_VAL = 4;
    public static final int TLVTAGTYPE_OLD_INT_VAL = 5;
    public static final int TLVTAGTYPE_NEW_LONG_VAL = 6;
    public static final int TLVTAGTYPE_OLD_LONG_VAL = 7;
    public static final int TLVTAGTYPE_NEW_BUFFER_VAL = 8;
    public static final int TLVTAGTYPE_OLD_BUFFER_VAL = 9;
    public static final int TLVTAGTYPE_IS_VALUE_CHANGED = 10;

    //XLA request TLV message ID's
    public static final Integer SUBSYSTEM_TAG_ID = 1;
    public static final Integer TABLE_DETAILS_TAG_ID = 2;
    public static final Integer TABLENAME_TAG_ID = 1;
    public static final Integer DATASTORE_TAG_ID = 2;


}