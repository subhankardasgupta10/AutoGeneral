package sample.com.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sample.com.au.model.AutoGeneralTopLevel;
import sample.com.au.model.AutoGeneralUpdateTopLevel;
import sample.com.au.service.AutoGeneralService;
import static sample.com.au.constants.AutoGeneralConstants.API_JSON_RESPONSE;
import static sample.com.au.constants.AutoGeneralConstants.GET_APP_RESOURCE;
import static sample.com.au.constants.AutoGeneralConstants.GET_ID_APP_RESOURCE;

@RestController
public class AutoGeneralController {

    private final AutoGeneralService autoGeneralService;

    @Autowired
    AutoGeneralController(final AutoGeneralService autoGeneralService) {
        this.autoGeneralService = autoGeneralService;
    }

    @RequestMapping(value = GET_APP_RESOURCE, produces = {API_JSON_RESPONSE}, method = RequestMethod.GET)
    public ResponseEntity<AutoGeneralTopLevel> getValidateBrackets(@RequestParam(value = "input") String input) {
        AutoGeneralTopLevel autoGeneralTopLevel = autoGeneralService.validateBrackets(input);
        return ResponseEntity.ok(autoGeneralTopLevel);
    }

    @RequestMapping(value = GET_APP_RESOURCE, produces = {API_JSON_RESPONSE}, method = RequestMethod.POST)
    public ResponseEntity<AutoGeneralUpdateTopLevel> postValidateBrackets(@RequestBody AutoGeneralUpdateTopLevel body) {
        AutoGeneralUpdateTopLevel autoGeneralUpdateTopLevel = autoGeneralService.saveBrackets(body);
        return ResponseEntity.ok(autoGeneralUpdateTopLevel);
    }

    @RequestMapping(value = GET_ID_APP_RESOURCE, produces = {API_JSON_RESPONSE}, method = RequestMethod.GET)
    public ResponseEntity<AutoGeneralUpdateTopLevel> getValidateBrackets(@PathVariable int id) {
        AutoGeneralUpdateTopLevel autoGeneralUpdateTopLevel = autoGeneralService.getIdBrackets(id);
        return ResponseEntity.ok(autoGeneralUpdateTopLevel);
    }

    @RequestMapping(value = GET_ID_APP_RESOURCE, produces = {API_JSON_RESPONSE}, method = RequestMethod.PATCH)
    public ResponseEntity<AutoGeneralUpdateTopLevel> getValidateBrackets(@PathVariable int id,
            @RequestBody AutoGeneralUpdateTopLevel body) {
        AutoGeneralUpdateTopLevel autoGeneralUpdateTopLevel = autoGeneralService.updateBrackets(id, body);
        return ResponseEntity.ok(autoGeneralUpdateTopLevel);
    }
}
