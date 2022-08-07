package com.liveasy.liveasy.load;

import com.liveasy.liveasy.entities.Load;
import com.liveasy.liveasy.services.LoadServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class LoadController {
  @Autowired
    private LoadServices loadServices;
    //To get all the load details
    @GetMapping("/load")
    public List<Load> getLoads()
    {
        return this.loadServices.getLoad();
    }

    //To get the load details by id
    @GetMapping("/load/{loadId}")
    public Load getLoad(@PathVariable String loadId)
    {
        return this.loadServices.getLoadById(Integer.parseInt(loadId));
    }

    //To add a new load details
    @PostMapping("/load")

    public Load addLoad(@RequestBody Load load)
    {
      return this.loadServices.addLoad(load);
    }

    // updating load details by id
    @PutMapping("/load/{loadId}")
    public Load updateLoad(@RequestBody Load load){
      return this.loadServices.updateLoad(load);
    }

    //deleting load details by id
    @DeleteMapping("/load/{loadId}")

    public ResponseEntity<HttpStatus> deleteLoad(@PathVariable String loadId)
    {
      try
      {
        this.loadServices.deleteLoad(Integer.parseInt(loadId));
        return new ResponseEntity<>(HttpStatus.OK);
      }
      catch (Exception e)
      {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }


}
