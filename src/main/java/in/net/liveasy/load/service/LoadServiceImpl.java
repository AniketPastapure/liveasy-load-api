package in.net.liveasy.load.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.net.liveasy.load.dto.LoadDto;
import in.net.liveasy.load.entity.Load;
import in.net.liveasy.load.repository.LoadRepository;


@Service
public class LoadServiceImpl implements LoadService {
   
	
	@Autowired
	private LoadRepository loadRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	
	@Override
	public List<LoadDto> findAll() {
		List<Load> findAll = loadRepository.findAll();
		List<LoadDto> loadList = findAll
				  .stream()
				  .map(load -> modelMapper.map(load, LoadDto.class))
				  .collect(Collectors.toList());
		return loadList;
	}
	
	@Override
	public LoadDto getLoadById(Long id) {
		Optional<Load> findById = loadRepository.findById(id);
//		if(findById.isEmpty()) {
			return modelMapper.map(findById.get(), LoadDto.class);
//		}
//		return null;
	}

	@Override
	public void save(LoadDto info) {
		Load load = modelMapper.map(info, Load.class);
		loadRepository.save(load);
	}

	@Override
	public void delete(long id) {
		LoadDto loadDto = getLoadById(id);
		
		Load load = modelMapper.map(loadDto, Load.class);
		
		loadRepository.delete(load);
//		loadRepository.deleteById(null);
		
	}
	
	

	

}
