package com.bridgelabz;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class AddressBookJsonFileWriter {
    public static final String ADDRESS_BOOK_JSON_PATH = "C:\\Users\\vinit\\IdeaProjects\\AddressBook\\src\\main\\java\\com\\bridgelabz\\ContactsJsonFile.json";

    public void writeToJson(List<Contact> listContactDetails){
        try(Writer writer = new FileWriter(ADDRESS_BOOK_JSON_PATH)){

            JSONObject jsonAddressBookObject = new JSONObject();
            JSONArray jsonArr = new JSONArray();
            for (Contact contact : listContactDetails) {
                jsonAddressBookObject.put("First Name",  contact.getFirstName());
                jsonAddressBookObject.put("Last Name", contact.getLastName());
                jsonAddressBookObject.put("Address", contact.getAddress());
                jsonAddressBookObject.put("City", contact.getCity());
                jsonAddressBookObject.put("State", contact.getState());
                jsonAddressBookObject.put("Zip Code", contact.getZip());
                jsonAddressBookObject.put("Phone Number", contact.getPhoneNumber());
                jsonAddressBookObject.put("Email", contact.getEmail());

                writer.write(jsonAddressBookObject.toJSONString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
