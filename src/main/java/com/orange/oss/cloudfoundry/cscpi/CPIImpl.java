package com.orange.oss.cloudfoundry.cscpi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

import org.jclouds.cloudstack.CloudStackApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class CPIImpl implements CPI{

	private static Logger logger=LoggerFactory.getLogger(CPIImpl.class);
	
	
	@Autowired
	CloudStackApi api;
	
	
    public String create_vm(String agent_id,
                            String stemcell_id,
                            JsonNode resource_pool,
                            JsonNode networks,
                            List<String> disk_locality,
                            Map<String,String> env) {

        ObjectMapper mapper = new ObjectMapper();

        return null;
    }

	@Override
	public void initialize(Map<String, String> options) {
		logger.info("",options);
		
	}

	@Override
	public String current_vm_id() {
		logger.info("current_vm_id");
		return null;
	}

	@Override
	public String create_stemcell(String image_path,
			Map<String, String> cloud_properties) {
		logger.info("current_stemcell");
		return null;
	}

	@Override
	public void delete_stemcell(String stemcell_id) {
		logger.info("delete_stemcell");
		
	}

	@Override
	public void delete_vm(String vm_id) {
		logger.info("delete_vm");
		
	}

	@Override
	public boolean has_vm(String vm_id) {
		logger.info("has_vm ?");
		return false;
	}

	@Override
	public boolean has_disk(String disk_id) {
		logger.info("has_disk ?");
		return false;
	}

	@Override
	public void reboot_vm(String vm_id) {
		logger.info("reboot_vm");
		
	}

	@Override
	public void set_vm_metadata(String vm_id, Map<String, String> metadata) {
		logger.info("set vm metadata");
		
	}

	@Override
	public void configure_networks(String vm_id, JsonNode networks) {
		logger.info("configure network");
		
	}

	@Override
	public String create_disk(Integer size, Map<String, String> cloud_properties) {
		logger.info("create_disk");
		return null;
	}

	@Override
	public void delete_disk(String disk_id) {
		logger.info("delete_disk");
		
	}

	@Override
	public void attach_disk(String vm_id, String disk_id) {
		logger.info("attach disk");
		
	}

	@Override
	public String snapshot_disk(String disk_id, Map<String, String> metadata) {
		logger.info("snapshot disk");
		return null;
	}

	@Override
	public void delete_snapshot(String snapshot_id) {
		logger.info("delete snapshot");
		
	}

	@Override
	public void detach_disk(String vm_id, String disk_id) {
		logger.info("detach disk");
		
	}

	@Override
	public List<String> get_disks(String vm_id) {
		logger.info("get_disks");
		return null;
	}
    
    
    
    
}
