package com.orange.oss.cloudfoundry.cscpi.logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.orange.oss.cloudfoundry.cscpi.domain.Network;
import com.orange.oss.cloudfoundry.cscpi.domain.NetworkType;
import com.orange.oss.cloudfoundry.cscpi.domain.Networks;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)

public class UserDataGeneratorTest {

	@Autowired
	UserDataGenerator generator;
	
	@Test
	public void testUserDataGeneration() {

		Networks networks=new Networks();
		Network net=new Network();
		networks.networks.put("default", net);
		//net.type=NetworkType.dynamic;
		net.type=NetworkType.manual;
		net.ip="10.234.228.158";
		net.gateway="10.234.228.129";
		net.netmask="255.255.255.192";
		net.cloud_properties.put("name", "3112 - preprod - back");
		net.dns.add("10.234.50.180");
		net.dns.add("10.234.71.124");
		
		String userData=this.generator.userMetadata("my-vm",networks);
		
		String expected="{\"server\":{\"name\":\"my-vm\"},\"registry\":{\"endpoint\":\"http://admin:admin@127.0.0.1:8080\"},\"dns\":{\"nameserver\":[\"10.234.50.180\"]}}";

		JSONAssert.assertEquals(expected,userData,true);
		
	}

}
