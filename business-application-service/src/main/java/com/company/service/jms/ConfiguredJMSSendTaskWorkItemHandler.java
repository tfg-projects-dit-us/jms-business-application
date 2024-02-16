package com.company.service.jms;

import javax.jms.ConnectionFactory;

import org.jbpm.process.workitem.jms.JMSSendTaskWorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component("External Send Task")
public class ConfiguredJMSSendTaskWorkItemHandler extends JMSSendTaskWorkItemHandler {

    private JmsTemplate jmsTemplate;
    private static final Logger log = LogManager.getLogger();

    public ConfiguredJMSSendTaskWorkItemHandler(ConnectionFactory connectionFactory, JmsTemplate jmsTemplate) {
        super(connectionFactory, null);
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        try {
            log.info("Voy a pasar a jmsTemplate.send el workITem /n"+workItem);
            jmsTemplate.send("ExternalSignalQueue", (session) -> createMessage(workItem, session));
            manager.completeWorkItem(workItem.getId(), null);
            log.info("Se ejecuta el metodo executeWorkItem para el workITem /n"+workItem);
        } catch (Exception e) {
            handleException(e);
        }
    }
}
