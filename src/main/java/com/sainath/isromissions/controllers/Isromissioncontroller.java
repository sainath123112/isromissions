package com.sainath.isromissions.controllers;
import com.sainath.isromissions.models.Isromissions;
import com.sainath.isromissions.repository.Isromissionsrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/isro/api")
public class Isromissioncontroller {
    private final Isromissionsrepository isrorepositoryobj;
    @Autowired
    public Isromissioncontroller( Isromissionsrepository isrorepositoryobj) {
        this.isrorepositoryobj = isrorepositoryobj;
    }

    @GetMapping("/missions")
    public List<Isromissions> getIsroMissions()
    {
        return isrorepositoryobj.findAll();
    }
    @GetMapping("/missions/{id}")
    public ResponseEntity<Isromissions> getIsroMission(@PathVariable int id)
    {
        Optional<Isromissions> optionalmission = isrorepositoryobj.findById(id);

        if(optionalmission.isPresent())
        {
            Isromissions isromission = optionalmission.get();
            return ResponseEntity.ok(isromission);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add-mission")
    public ResponseEntity<String> postIsroMission(@RequestBody Isromissions isromission)
    {

        isrorepositoryobj.save(isromission);
        return ResponseEntity.ok("Mission Added Successfully..!");
    }

    @PutMapping("/update-mission/{id}")
    public String updateMission(@PathVariable int id, @RequestBody Isromissions updatemission)
    {
        Optional<Isromissions> updateoptionalmission = isrorepositoryobj.findById(id);
        if(updateoptionalmission.isPresent()) {
            Isromissions missionToUpdate = updateoptionalmission.get();

            missionToUpdate.setMission_name(updatemission.getMission_name());
            missionToUpdate.setLaunch_date(updatemission.getLaunch_date());
            missionToUpdate.setLaunch_vehicle(updatemission.getLaunch_vehicle());
            missionToUpdate.setOrbit_type(updatemission.getOrbit_type());
            missionToUpdate.setApplication(updatemission.getApplication());
            missionToUpdate.setRemarks(updatemission.getRemarks());

            isrorepositoryobj.save(missionToUpdate);
            System.out.println(missionToUpdate);
            return "Mission Updated Successfully..!";

        }
        else {
            return "Mission Failed to Update..!";
        }

    }

    @DeleteMapping("/delete-mission/{id}")
    public String deleteIsroMission(@PathVariable int id) {

        isrorepositoryobj.deleteById(id);
        return "Mission Deleted Successfully..!";
    }

}
