package in.net.liveasy.load.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.net.liveasy.load.dto.LoadDto;
import in.net.liveasy.load.exception.ResourceNotFoundException;
import in.net.liveasy.load.service.LoadService;

@RestController
public class LoadController {

	@Autowired
	private LoadService loadService;

	@GetMapping("/load")
	public List<LoadDto> getAllData() {
		return loadService.findAll();
	}

	@GetMapping("/load/{id}")
	public ResponseEntity<LoadDto> getDataById(@PathVariable Long id) throws ResourceNotFoundException {
		LoadDto loadDto = loadService.getLoadById(id);
		if (loadDto != null) {
			return ResponseEntity.ok().body(loadDto);
		}
		throw new ResourceNotFoundException("Data not found for this id :: " + id);
	}

	@PostMapping("/load")
	public ResponseEntity<String> saveData(@RequestBody LoadDto info) {
		loadService.save(info);
		return new ResponseEntity<String>("Saved Successfully", HttpStatus.CREATED);
	}

	@PutMapping("/load/{id}")
	public Map<String, Boolean> updateDataById(@PathVariable Long id, @RequestBody LoadDto old)
			throws ResourceNotFoundException {

		LoadDto info = loadService.getLoadById(id);

		info.setLoadingPoint(old.getLoadingPoint());
		info.setUnloadingPoint(old.getUnloadingPoint());
		info.setProductType(old.getProductType());
		info.setTruckType(old.getTruckType());
		info.setNoOfTrucks(old.getNoOfTrucks());
		info.setComment(old.getComment());
		info.setDate(old.getDate());
		info.setWeight(old.getWeight());

		this.loadService.save(info);

		Map<String, Boolean> response = new HashMap<>();
		response.put("Updated Succesfully", Boolean.TRUE);
		return response;

	}
	
	@DeleteMapping("/load/{id}")
	public ResponseEntity<String> deleteData(@PathVariable Long id){
		loadService.delete(id);
		return new ResponseEntity<String>("Delete Successfully", HttpStatus.OK);
		
	}



}
