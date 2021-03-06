package com.orange.oss.cloudfoundry.cscpi.cep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)

@ConfigurationProperties
public class CEPTest {

	@Autowired
	CEPInterface cep;

	@Test
	public void testPatternDetachDiskVmDelete() {
		for (int i = 0; i < 500; i++) {
			String vmId = "vm-" + i;
			String diskId = "disk-" + i;
			CPIEvent event = new CPIDetachDiskOK(vmId, diskId);
			cep.sendEvent(event);
			cep.sendEvent(new CPIDeleteVmOK(vmId, diskId));

		}

	}

}
