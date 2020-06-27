package com.home.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.model.Branches;
import com.home.model.BranchesWithPredicting;
import com.home.model.ErrorResponse;
import com.home.service.BranchesService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-27T09:33:29.143Z")

@Controller
public class BranchesController implements BranchesApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final BranchesService branchesService;

    @Autowired
    public BranchesController(BranchesService branchesService, ObjectMapper objectMapper, HttpServletRequest request) {
        this.branchesService = branchesService;
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity getBranchUsingGET(@ApiParam(value = "id", required = true) @PathVariable("id") Long id) {
        Optional<Branches> branches = branchesService.getBranchesById(id);
        if (branches.isPresent()) {
            return new ResponseEntity<Branches>(branches.get(), HttpStatus.OK);
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setStatus("branch not found");
            return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<BranchesWithPredicting> getBranchesWithPredictingUsingGET(@NotNull @ApiParam(value = "dayOgWeek", required = true) @Valid @RequestParam(value = "dayOgWeek", required = true) Integer dayOgWeek, @NotNull @ApiParam(value = "hourOfDay", required = true) @Valid @RequestParam(value = "hourOfDay", required = true) Integer hourOfDay, @ApiParam(value = "id",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BranchesWithPredicting>(objectMapper.readValue("{  \"address\" : \"address\",  \"dayOfWeek\" : 0,  \"hourOfDay\" : 6,  \"lon\" : 5.637376656633329,  \"id\" : 1,  \"title\" : \"title\",  \"lat\" : 5.962133916683182,  \"predicting\" : 2}", BranchesWithPredicting.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                return new ResponseEntity<BranchesWithPredicting>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BranchesWithPredicting>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity getNearBranchUsingGET(@NotNull @ApiParam(value = "lat", required = true) @Valid @RequestParam(value = "lat", required = true) Double lat,@NotNull @ApiParam(value = "lon", required = true) @Valid @RequestParam(value = "lon", required = true) Double lon) {
        List<Branches> branches =  branchesService.getAllBranches();
        if (branches.isEmpty()){
            return new ResponseEntity<List<Branches>>(branches, HttpStatus.NOT_IMPLEMENTED);
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setStatus("branch not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
