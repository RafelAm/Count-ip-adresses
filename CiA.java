import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountIPAddressesTest {

	@Test
	public void ipsBetween() throws Exception {
		assertEquals( 50, CountIPAddresses.ipsBetween( "10.0.0.0", "10.0.0.50" ) );
		assertEquals( 246, CountIPAddresses.ipsBetween( "20.0.0.10", "20.0.1.0" ) );
    assertEquals( (1l << 32l) - 1l, CountIPAddresses.ipsBetween( "0.0.0.0", "255.255.255.255" ) );
	}
}


public class CountIPAddresses {

	public static long ipsBetween(String start, String end) {
		
     String[] ips = start.split("[.]");
     String[] ipe = end.split("[.]");
    
    long ips1 = 1;
    long ipe1 = 1;
    
    for(int i = 0; i < ips.length;i++){
      ips1 += Math.pow(256, 3-i) * Long.parseLong(ips[i]);
      ipe1 += Math.pow(256, 3-i) * Long.parseLong(ipe[i]);
    }

    return Math.abs(ips1 - ipe1);
	}
}
