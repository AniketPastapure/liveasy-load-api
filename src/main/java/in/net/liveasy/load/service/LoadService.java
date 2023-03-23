package in.net.liveasy.load.service;

import java.util.List;

import in.net.liveasy.load.dto.LoadDto;

public interface LoadService {

	List<LoadDto> findAll();
	
	LoadDto getLoadById(Long id);

	void save(LoadDto info);

	void delete(long id);

	

}
