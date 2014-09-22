package com.ellin.gemfire.commands;

import com.ellin.gemfire.util.CacheFactory;
import groovy.ui.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.stereotype.Component;


/**
 * Created with IntelliJ IDEA.
 * User: jellin
 * Date: 7/8/14
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ShellCommands implements CommandMarker {


    @Autowired
    CacheFactory cacheFactory = null;

    @CliCommand(value = "console", help = "Run Groovy Console")
    public void runConsole(){

        Console console = new Console();
        console.setVariable("queryUtil",null);
        console.run();

    }

    public void connectLocator(String locator, int port){

    }

    public void connectServer(String server, int port){

    }

    public void addRegion(String region){

    }

    public void loadCustomers(){

    }

    public void loadOrders(){

    }


}
