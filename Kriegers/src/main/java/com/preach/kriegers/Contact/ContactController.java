package com.preach.kriegers.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getContact() {
        return contactService.getContact();
    }

    @PostMapping
    public void registerNewContact(@RequestBody Contact contact) {
        contactService.addNewContact(contact);
    }

    @DeleteMapping(path = "{contractId}")
    public void deleteContact(
            @PathVariable("contractId") Long contractId) {
        contactService.deleteContact(contractId);
    }

    @PutMapping(path = "{contractId}")
    public void updateContract(
            @PathVariable("contractId") Long contractId,
            @RequestBody(required = false) String firstName,
            @RequestBody(required = false) String lastName,
            @RequestBody(required = false) String email) {
        contactService.updateContact(contractId, firstName, lastName, email);
    }
}
