package org.yurov.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.yurov.model.Base;
import org.yurov.service.BaseService;

import java.util.List;

@RestController
//brs - base registry service
@RequestMapping("/api/v1/brs/")
public class BaseControllerV1 {
    private final BaseService baseService;
    @Autowired
    public BaseControllerV1(BaseService baseService) {
        this.baseService = baseService;
    }

    /*
     * GET localhost:8080/api/v1/brs/owner/владелец базы
     */
    @RequestMapping(value = "/owner/{owner}",method = RequestMethod.GET)
    public ResponseEntity<List<Base>> getBaseByOwner(@PathVariable("owner") String owner){
        List<Base> basesAssignOwner;
        try{
            basesAssignOwner = baseService.findByOwner(owner);
            if(basesAssignOwner.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(basesAssignOwner, HttpStatus.OK);
    }

    /*
     * GET localhost:8080/api/v1/brs/base/имя базы
     */
    @RequestMapping(value = "/base/{baseName}",method = RequestMethod.GET)
    public ResponseEntity<List<Base>> getBaseByBaseName(@PathVariable("baseName") String baseName){
        List<Base> requiedBaseInfo;
        try{
            requiedBaseInfo = baseService.findByBaseName(baseName);
            if(requiedBaseInfo.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(requiedBaseInfo, HttpStatus.OK);
    }

    /*
     * GET localhost:8080/api/v1/brs/base/
     */
    @RequestMapping(value = "/base/",method = RequestMethod.GET)
    public ResponseEntity<List<Base>> getAllData(){
        List<Base> allBases;
        try{
            allBases = baseService.findAll();
            if(allBases.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allBases, HttpStatus.OK);
    }


    /*
     * POST localhost:8080/api/v1/brs/base/add/
     *
     * body:
    {
        "baseName": "base0322",
        "baseOwner": "user222",
        "createdDate": "2023-02-04",
        "type": "Mysql",
        "size": 42283
    }
    *
    */
    @RequestMapping(value = "/base/add/",method = RequestMethod.POST)
    public ResponseEntity<Base> uploadData(@RequestBody @Validated Base base){
        HttpHeaders headers = new HttpHeaders();
        if(base==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.baseService.saveBase(base);
        return new ResponseEntity<>(base,headers, HttpStatus.CREATED);
    }


}
