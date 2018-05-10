package com.sriwin.kafka.test;

import com.sriwin.kafka.driver.DriverScript;
import com.sriwin.kafka.service.ProduceService;
import com.sriwin.kafka.utils.DirUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ProducerTest extends DriverScript {
  private static final Logger logger = LoggerFactory.getLogger(ProducerTest.class.getName());

  public static void main(String[] args) {
    ProducerTest producerTest = new ProducerTest();
    producerTest.doInit();
    producerTest.sendMsg();
  }

  public void sendMsg() {
    logger.info("Launching producer");
    try {
      String filePath = DirUtil.getUserDir() + "test.txt";
      String fileContent = FileUtils.readFileToString(new File(filePath), "UTF-8");
      ProduceService produceService = new ProduceService();
      produceService.sendMsg(fileContent);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}