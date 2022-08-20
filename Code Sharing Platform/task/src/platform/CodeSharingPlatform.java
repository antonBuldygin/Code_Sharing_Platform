package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    ServiceImpl service;

    @Autowired
    public CodeSharingPlatform(ServiceImpl service) {
        this.service = service;
    }


    String codeInitial = """
            public static void main(String[] args) {
            SpringApplication.run(CodeSharingPlatform.class, args);}""";

    String localDate = "2018-11-12 21:19:52";

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    @GetMapping(value = "/code/{idN}")
    public ModelAndView getCode(@PathVariable("idN") final String idN) {
        Code code = service.findByUuId(idN);
        ModelAndView model = new ModelAndView();
        if(code==null){model.setStatus(HttpStatus.NOT_FOUND); return model;}
        int diff=  ((int) (code.getTimeConstant() - ChronoUnit.SECONDS.between(LocalDateTime.parse(code.getDate()), LocalDateTime.now())));

        if (diff > 0 && (code.getTimeR()||code.getLogic()) ) {
            code.setTime(diff);
            service.updateCode(code);
        }
        else if (diff  <= 0  && (code.getTimeR() || code.getLogic())){
            model.setStatus(HttpStatus.NOT_FOUND); return model;
        }
        if (code.getViews() > 0 && (code.getViewsR()||code.getLogic()) ) {
            int viewsUpdated = code.getViews() - 1;
            code.setViews(viewsUpdated);
            service.updateCode(code);
        }
        else if (code.getViews() <= 0 && (code.getViewsR() || code.getLogic())) {
            model.setStatus(HttpStatus.NOT_FOUND); return model;
        }



//        if (code.getTime() > 0
////                && (code.getOnlyOne() || code.getLogic())
//        ) {
//            code.setTime((int) (code.getTime() - ChronoUnit.SECONDS.between(LocalDateTime.parse(code.getDate()), LocalDateTime.now())));
//            service.updateCode(code);
//        }
//        if (code.getViews() > 0
////                && (code.getOnlyOne() || code.getLogic())
//        ) {
//            int viewsUpdated = code.getViews() - 1;
//            code.setViews(viewsUpdated);
//            service.updateCode(code);
//        }

        model.addObject("date", code.getDate());
        model.addObject("code", code.getCode());

        if (code.getTimeR() || code.getLogic()){ model.addObject("time", "The code will be available for " + code.getTime() + " seconds");}
        if (code.getViewsR()||code.getLogic()) {model.addObject("views", code.getViews() + " more views allowed");}

        model.setViewName("index");
        return model;
    }


    @GetMapping("/api/code/{idN}")
    public ResponseEntity<?> returnOne(@PathVariable("idN") final String idN) {

        Code code = service.findByUuId(idN);
        if(code==null){ return new ResponseEntity<>("404 Not Found", HttpStatus.NOT_FOUND);}
       int diff=  ((int) (code.getTimeConstant() - ChronoUnit.SECONDS.between(LocalDateTime.parse(code.getDate()), LocalDateTime.now())));
        if (diff > 0 && (code.getTimeR()||code.getLogic()) ) {
            code.setTime(diff);
            service.updateCode(code);
        }
        else if (diff  <= 0  && (code.getTimeR() || code.getLogic())){
            return new ResponseEntity<>("404 Not Found", HttpStatus.NOT_FOUND);
        }
        if (code.getViews() > 0 && (code.getViewsR()||code.getLogic()) ) {
            int viewsUpdated = code.getViews() - 1;
            code.setViews(viewsUpdated);
            service.updateCode(code);
        }
       else if (code.getViews() <= 0 && (code.getViewsR() || code.getLogic())) {
            return new ResponseEntity<>("404 Not Found", HttpStatus.NOT_FOUND);
        }


//        if (diff  <= 0  && (code.getTimeR() || code.getLogic())) {
//            return new ResponseEntity<>("404 Not Found", HttpStatus.NOT_FOUND);
//        }
//        if (code.getViews() <= 0 && (code.getViewsR() || code.getLogic())) {
//            return new ResponseEntity<>("404 Not Found", HttpStatus.NOT_FOUND);
//        }

//            Map<String, String> map = new TreeMap<>(Map.of("code", String.valueOf(code.getCode()), "date", code.getDate(),
//                    "time", String.valueOf(code.getTime()), "views", String.valueOf(code.getViews())));



            return new ResponseEntity<>(code, HttpStatus.OK);



    }

    @GetMapping("/api/code/latest")
    public ResponseEntity<?> returnOne() {

        return new ResponseEntity<>(service.latest(), HttpStatus.OK);


    }

    @GetMapping("/code/latest")
    public ModelAndView returnLatest() {
        ModelAndView model = new ModelAndView();
        model.addObject("latest", service.latest());
        model.setViewName("latest");
        return model;


    }

    @GetMapping(value = "/code/new")
    public ModelAndView getCodeNew() {
        ModelAndView model = new ModelAndView();
        model.setViewName("new");
        return model;
    }

    @PostMapping("/api/code/new")
    public ResponseEntity<?> setAppointment(@RequestBody Code cod) {

        localDate = (String.valueOf(LocalDateTime.now()));
        codeInitial = cod.getCode();
        String id = String.valueOf(service.newCode(cod, localDate));

        Map<String, String> map = new HashMap<>(Map.of("id", id));

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/api/code/delete")
    public ResponseEntity<?> delete() {
        List<Long> list = service.getAll();
        service.delete();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
