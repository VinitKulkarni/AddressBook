package com.bridgelabz;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class AddressBookCSVFileWriter {
    public static final String ADDRESS_BOOK_CSV_PATH = "C:\\Users\\vinit\\IdeaProjects\\AddressBook\\src\\main\\java\\com\\bridgelabz\\ContactsCSVFile.csv";
    public void writeToCSV(List<Contact> listContactDetails) throws IOException {
        Writer writer = null;
        try {
            writer = new FileWriter(ADDRESS_BOOK_CSV_PATH);
            {
                StatefulBeanToCsvBuilder<Contact> builder = new StatefulBeanToCsvBuilder<>(writer);
                StatefulBeanToCsv<Contact> beanWriter = builder.withQuotechar(CSVWriter.NO_ESCAPE_CHARACTER).build();
                beanWriter.write(listContactDetails);
            }
        } catch (IOException ignored) {
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } finally {
            assert writer != null;
            writer.close();
        }
    }
}
