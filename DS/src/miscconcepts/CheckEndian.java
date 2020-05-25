


package miscconcepts;

import java.nio.ByteOrder;
public class CheckEndian {
	public static boolean isBigEndian() {
	   if(ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN))
	      return true;
	   return false;
	}
	public static boolean isLittleEndian() {
	   if(ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN))
	      return true;
	   return false;
	}
}
