package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class operations {
@Autowired repository ob;
@PostMapping("/add")
public String save(@RequestBody travel travel1)
{
	travel w= new travel();
	int id=travel1.getTravelId();
	String name=travel1.getName();
	String description=travel1.getDescription();
	
	w.setTravelId(id);
	w.setName(name);
	w.setDescription(description);
	
	travel first = new travel(id,name,description);
	ob.save(first);
	return "Added successfully";
}

@GetMapping("/travel")
public List<travel> getAlldetails()
{
	return ob.findAll();
}

@GetMapping("travel/{id}")
public List<travel> getById(@PathVariable("id") int id)
{
	return ob.findById(id);
}

@GetMapping("travel/name/{name}")
public List<travel> getByName(@PathVariable("name") String name)
{
	return ob.findByName(name);
}

@PutMapping("/update/{id}")
public String update(@RequestBody travel x,@PathVariable("id") int id)
{
	int travelId1=x.getTravelId();
	String name=x.getName();
	String description=x.getDescription();
	ob.update(travelId1,name,description,id);
	return "Successfully updated";
}

@DeleteMapping("delete/{id}")
public String deleteById(@PathVariable("id") int id)
{
	ob.deleteAllByIdInBatch(id);
	return "Items deleted successfully";
}
}



