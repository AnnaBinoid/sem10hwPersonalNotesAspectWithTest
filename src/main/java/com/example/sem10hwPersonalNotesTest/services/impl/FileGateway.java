package com.example.sem10hwPersonalNotesTest.services.impl;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface FileGateway {

    /**
     * Выполняет запись переданных данных в файл, названный
     * значением заголовка, переданным через аргумент filename/
     * @param filename - переменная для хранения значения, переданного
     *                 в HTTP заголовке с ключом FileHeaders.FILENAME
     * @param data - данные для записи в файл.
     */
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
