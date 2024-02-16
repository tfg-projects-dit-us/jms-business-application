package com.company.service.jms;

import javax.jms.BytesMessage;

import org.jbpm.process.workitem.jms.JMSSignalReceiver;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class ReceiveJMSEvents extends JMSSignalReceiver {
    private static final Logger log = LogManager.getLogger();

    @JmsListener(destination = "ExternalSignalQueue")
    public void processMessage(BytesMessage content) {
        log.info("Recibido mensaje en ReceiveJMSEvents "+content);
        super.onMessage(content);
    }
    
}
