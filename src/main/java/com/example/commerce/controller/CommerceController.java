package com.example.commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommerceController {

    @GetMapping(value = "/authentication-login1")
    public String authenticationlogin1(){
        return "html/authentication-login1";
    }

    @GetMapping(value = "/authentication-register1")
    public String authenticationregister1(){
        return "html/authentication-register1";
    }

    @GetMapping(value = "/chart-chart-js")
    public String chartchartjs(){
        return "html/chart-chart-js";
    }

    @GetMapping(value = "/chart-knob")
    public String chartknob(){
        return "html/chart-knob";
    }

    @GetMapping(value = "/chart-morris")
    public String chartmorris(){
        return "html/chart-morris";
    }

    @GetMapping(value = "/form-checkbox-radio")
    public String formcheckboxradio(){
        return "html/form-checkbox-radio";
    }
    @GetMapping(value = "/form-input-grid")
    public String forminputgrid(){
        return "html/form-input-grid";
    }
    @GetMapping(value = "/form-inputs")
    public String forminputs(){
        return "html/form-inputs";
    }
    @GetMapping(value = "/icon-fontawesome")
    public String iconfontawesome(){
        return "html/icon-fontawesome";
    }
    @GetMapping(value = "/icon-simple-lineicon")
    public String iconsimplelineicon(){
        return "html/icon-simple-lineicon";
    }
    @GetMapping(value = "/index")
    public String index(){

        return "html/index";
    }
    @GetMapping(value = "/table-basic")
    public String tablebasic(){
        return "html/table-basic";
    }
    @GetMapping(value = "/table-dark-basic")
    public String tabledarkbasic(){
        return "html/table-dark-basic";
    }
    @GetMapping(value = "/table-datatable-basic")
    public String tabledatatablebasic(){
        return "html/table-datatable-basic";
    }
    @GetMapping(value = "/table-layout-coloured")
    public String tablelayoutcoloured(){
        return "html/table-layout-coloured";
    }
    @GetMapping(value = "/table-sizing")
    public String tablesizing(){
        return "html/table-sizing";
    }
    @GetMapping(value = "/ticket-list")
    public String ticketlist(){
        return "html/ticket-list";
    }
    @GetMapping(value = "/ui-bootstrap")
    public String uibootstrap(){
        return "html/ui-bootstrap";
    }
    @GetMapping(value = "/ui-breadcrumb")
    public String uibreadcrumb(){
        return "html/ui-breadcrumb";
    }
    @GetMapping(value = "/ui-buttons")
    public String uibuttons(){
        return "html/ui-buttons";
    }
    @GetMapping(value = "/ui-cards")
    public String uicards(){
        return "html/ui-cards";
    }
    @GetMapping(value = "/ui-carousel")
    public String uicarousel(){
        return "html/ui-carousel";
    }
    @GetMapping(value = "/ui-grid")
    public String uigrid(){
        return "html/ui-grid";
    }
    @GetMapping(value = "/ui-list-media")
    public String uilistmedia(){
        return "html/ui-list-media";
    }
    @GetMapping(value = "/ui-modals")
    public String uimodals(){
        return "html/ui-modals";
    }
    @GetMapping(value = "/ui-notification")
    public String uinotification(){
        return "html/ui-notification";
    }
    @GetMapping(value = "/ui-popover")
    public String uipopover(){
        return "html/ui-popover";
    }
    @GetMapping(value = "/ui-progressbar")
    public String uiprogressbar(){
        return "html/ui-progressbar";
    }
    @GetMapping(value = "/ui-scrollspy")
    public String uiscrollspy(){
        return "html/ui-scrollspy";
    }
    @GetMapping(value = "/ui-spinners")
    public String uispinner(){
        return "html/ui-spinner";
    }
    @GetMapping(value = "/ui-tab")
    public String uitab(){
        return "html/ui-tab";
    }
    @GetMapping(value = "/ui-toasts")
    public String uitoasts(){
        return "html/ui-toasts";
    }
    @GetMapping(value = "/ui-tooltip-popover")
    public String uitooltippopover(){
        return "html/ui-tooltip-popover";
    }
    @GetMapping(value = "/ui-typography")
    public String uitypography(){
        return "html/ui-typography";
    }



}
