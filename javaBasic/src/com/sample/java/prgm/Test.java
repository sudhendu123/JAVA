package com.sample.java.prgm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

//import com.sample.java.array.ArrayList;

public class Test {
	public static final int DISPATCHER_GROUP_TYPE = 2;
	final static int a=10;
	private static List<String> getDeletedBroadcasters(List<KnCorpSubscriberDTO> finalGroupMemList, List<String> finalBroadcasters) {
        List<String> deletedBroadcasters = new ArrayList<>();
        for (String mdn : finalBroadcasters) {
            KnCorpSubscriberDTO subscriberDTO = new KnCorpSubscriberDTO();
            subscriberDTO.setMdn(mdn);
            if (!finalGroupMemList.contains(subscriberDTO)) {
                deletedBroadcasters.add(mdn);
            }
        }
        finalBroadcasters.removeAll(deletedBroadcasters);
        return deletedBroadcasters;
    }
	
	 enum SUBS_CLIENT_TYPE {
	        UNKNOWN(0),
	        HANDSET(1),
	        DESKTOP(2),
	        DISPATCH_CLIENT(3),
	        POC_DONOR_RADIO(4),
	        POC_WIFIONLY(5),
	        THIRDPARTYPOCCLIENT(6),
	        ALIASMDN(7),
	        GROUPMDN(8),
	        MOBILEAPI(13),
	        CROSSCARRIER(10),
	        PDVCONNECT(11),
	        NOTFOUND(-1),
	        THIRDPARTYDISPATCHERCLIENT(12),
	    	//LMR client type changes
	        PTTRADIOHANDSETCLIENT(14),
	        PTTRADIOCROSSCARRIERCLIENT(15),
	        PTTRADIOWIFIONLYCLIENT(16),
	        SGMDNPATCH(17),
	        DATAGROUPMDN(18);



	        int subsClientType;

	        SUBS_CLIENT_TYPE(int type) {
	            subsClientType = type;
	        }

	        public int value() {
	            return subsClientType;
	        }

	        private static final Map<Integer, SUBS_CLIENT_TYPE> map = new HashMap<Integer, SUBS_CLIENT_TYPE>();

	        static {
	        	for (SUBS_CLIENT_TYPE element : SUBS_CLIENT_TYPE.values()) {
					map.put(element.value(), element);
				}
	        }

	        public static SUBS_CLIENT_TYPE getValueOf(int value) {
	        	SUBS_CLIENT_TYPE client_TYPE =  map.get(value);
	        	if (client_TYPE == null) {
	        		client_TYPE = NOTFOUND;
	        	}
	        	return client_TYPE;
	        }

	    }
	 
	public static void main(String[] args) {
		int newSubsClientType =1;
		int oldSubsClientType =5;
		String str = ""+SUBS_CLIENT_TYPE.HANDSET.value()+"|"+SUBS_CLIENT_TYPE.PTTRADIOHANDSETCLIENT.value()+","+SUBS_CLIENT_TYPE.CROSSCARRIER.value()+"|"+SUBS_CLIENT_TYPE.PTTRADIOCROSSCARRIERCLIENT.value()+","+SUBS_CLIENT_TYPE.PTTRADIOWIFIONLYCLIENT.value()+"|"+SUBS_CLIENT_TYPE.POC_WIFIONLY.value()+"";
		String[] regEx1 = str.split(",");
		for(int i=0;i<regEx1.length;i++) {
		    if(String.valueOf(oldSubsClientType).matches(regEx1[i]) && String.valueOf(newSubsClientType).matches(regEx1[i])){
		    	System.out.println("Client type change skipped");
		    }
		}
		System.out.println(" ddone");
		
		List<KnCorpSubscriberDTO> finalGroupMemList =new ArrayList<KnCorpSubscriberDTO>();
		finalGroupMemList.add(new KnCorpSubscriberDTO("999850000065"));
		finalGroupMemList.add(new KnCorpSubscriberDTO("999850000193"));
		finalGroupMemList.add(new KnCorpSubscriberDTO("999850000101"));
		List<String> finalBroadcasters = new ArrayList<>();
		finalBroadcasters.add("999850000101");
		finalBroadcasters.add("999850000102");
		finalBroadcasters.add("999850000103");
		
		List<String> finalBroadcasters1 = new ArrayList<>();
		finalBroadcasters1.add("919850000065");
		finalBroadcasters1.add("919850000066");
		finalBroadcasters1.add("999850000101");
		//finalBroadcasters1.add("999850000102");
		
		finalBroadcasters1.retainAll(finalBroadcasters);
		System.out.println("common :"+finalBroadcasters);
		
	
		//finalBroadcasters.clear();		
		//finalBroadcasters.addAll(finalBroadcasters1);
		finalBroadcasters1.removeAll(finalBroadcasters);
		System.out.println("finalBroadcasters1 :"+finalBroadcasters1);
		System.out.println("finalBroadcasters :"+finalBroadcasters.isEmpty());
		
		
		
		List<String> res = getDeletedBroadcasters(finalGroupMemList, finalBroadcasters);
		System.out.println(" res :"+res);
		
		Set<Integer> removeGroupIds =new HashSet<>();
		removeGroupIds.add(1);
		Integer grpId=1;
		Map<Integer, Integer> groupIdNTypeMap = new HashMap<Integer, Integer>();
		groupIdNTypeMap.put(1, 2);
		boolean keys = groupIdNTypeMap.containsValue(2);
		System.out.println("contains :"+keys);
		System.out.println(" type="+groupIdNTypeMap.get(grpId).equals(DISPATCHER_GROUP_TYPE));
		
		
		
		
		Set<String> locWatcherGroupIdList = new HashSet<>();
		locWatcherGroupIdList.add("3");
		locWatcherGroupIdList.add("4");
		Set<String> locWatcherGroupIdList1 = new HashSet<>();
		locWatcherGroupIdList1.add("1");
		locWatcherGroupIdList1.add("2");
		locWatcherGroupIdList.removeAll(locWatcherGroupIdList1);
		System.out.println("removed ="+(locWatcherGroupIdList.size()==0));
		System.out.println("contains: "+locWatcherGroupIdList.contains(grpId.toString()));
		
		LinkedList<Integer> profileMdnLists=new LinkedList<>();
	  	profileMdnLists.add(3);
	  	profileMdnLists.add(2);
		LinkedHashMap<String, LinkedList<Integer>> delContactStatus =new LinkedHashMap<String, LinkedList<Integer>>();
		delContactStatus.put("1", profileMdnLists);
		delContactStatus.put("2", profileMdnLists);
		
		LinkedList<Integer> firstEntry = delContactStatus.entrySet().stream().findFirst().get().getValue();
	  	System.out.println(" firstEntry :"+firstEntry);
		Collection<String> dbMdnList =new ArrayList<>();
		dbMdnList.add("1");
		dbMdnList.add("2");
		
		Collection<String> req =new ArrayList<>();
		req.add("1");
		req.add("3");
		
		Map<String,String> onlineMdns =new HashMap<String, String>();
		List<String> onlineMdnList = new LinkedList<>(onlineMdns.keySet());
		System.out.println(" dbMdnList2:"+onlineMdnList.isEmpty());
		
		Collection<Integer> reqInt =new ArrayList<>();
		reqInt.add(1);
		reqInt.add(3);
		
		Collection<Integer> subs =new ArrayList<>();
		subs.add(1);
		
		//req.removeAll(dbMdnList);
		boolean containEl = reqInt.stream().allMatch(subs::contains);
		
		Set<Integer> subscrsCorpIds =new HashSet<>();
		subscrsCorpIds.add(1);
		subscrsCorpIds.add(1);
		
		Set<Integer> subscrsCorpIds1 =new HashSet<>();
		subscrsCorpIds1.add(1);
		boolean containsubscrsCorpIds1 = subscrsCorpIds.stream().allMatch(subscrsCorpIds1::contains);
		boolean containsAll = subscrsCorpIds1.containsAll(subscrsCorpIds);
		
		System.out.println(" containEl:"+containEl +" req;"+req.isEmpty()+" contains:"+containsubscrsCorpIds1);
		System.out.println(" containsAll:"+containsAll);
		
		Map<Integer,Student> map=new HashMap();
		
		List<Student> list=new ArrayList();
		list.add(new Student(1,"1",1));
		list.add(new Student(2,"2",2));
		
		for(Student i:list) {
			if(i.getAge()!=map.get(i).getAge()) {
				System.out.println("yes");
			}
		}
		
		int a[]=new int[10];
		a[0]=1;
		
		int a1[]= {1,2};
		System.out.println("1: "+a[1]);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
		for(int j:a1) {
			System.out.println(j); 
		}
		
		me(new int[] {2,3});
		
		int arr[][]= {{1,2,3},{3,4,5}};
		System.out.println("srr len:"+arr.length);
		for(int j=0;j<arr.length;j++) {
			System.out.println("j length :"+arr[j].length);
			for(int q=0;q<arr[j].length;q++) {
				System.out.println(" ar "+arr[j][q]);
			}
		}
		 
	}
	
	public static void me(int a[]) {
		for(int j:a) {
			System.out.println(j); 
		}
	}
	

}
abstract class anno{
	public abstract void ann();
}

class callTest implements Callable<String>{
	public String call() {
		return "in call";
		
	}
}


class Student {
	int rollno;
	String name;
	int age;

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
/**
	public int compareTo(Student st) {
		if (age == st.age)
			return 0;
		else if (age > st.age)
			return 1;
		else
			return -1;
	}
**/
	// reverse order
	/**
	  public int compareTo(Student st) {
		if (age == st.age)
			return 0;
		else if (age < st.age)
			return 1;
		else
			return -1;
	}
	**/
	/**
	public int compareTo(Student st){
	     int last = this.name.compareTo(st.name);
	     return last == 0 ? this.name.compareTo(st.name) : last;
	  }
	  **/
	
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", age=" + age + "]";
	}
	
	
}