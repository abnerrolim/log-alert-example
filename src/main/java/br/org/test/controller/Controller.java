package br.org.test.controller;

import br.org.test.controller.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {

    @GetMapping(value = "/log/{severe}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> log(@PathVariable("severe") Boolean severe) {
        log.debug("Request made with thowsEception = {} option", severe);
        if (severe) {
            log.error(LogUtils.alertSupportMarker(), "A disaster has occurred into system. Alert support team, please");
        } else {
            log.error("Not apocalyptical error");
        }
        return ResponseEntity.ok().build();
    }
}
