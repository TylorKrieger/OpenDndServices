package com.preach.kriegers.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public List<Contact> getContact() { return contactRepository.findAll();}

    public void addNewContact(Contact contact) {
        Optional<Contact> contactByEmail = contactRepository
                .findContactByEmail(contact.getEmail());
        if (contactByEmail.isPresent()) {
            throw new IllegalStateException("email is taken");
        }
        contactRepository.save(contact);
    }

    public void deleteContact(Long contractId) {
        boolean exists = contactRepository.existsById(contractId);
        if(!exists){
            throw new IllegalStateException
                    ("student with id " + contractId + "doesn't exist");
        }
        contactRepository.deleteById(contractId);
    }

    @Transactional
    public void updateContact(Long contractId,
                              String firstName,
                              String lastName,
                              String email) {
        Contact contact = contactRepository.findById(contractId)
                .orElseThrow(() -> new IllegalStateException(
                    "student with id " + contractId + "doesn't exist"));
        if (firstName != null &&
            firstName.length() > 0 &&
            !Objects.equals(contact.getFirstName(), firstName)) {
                contact.setFirstName(firstName);
        }
        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(contact.getLastName(), lastName)) {
            contact.setLastName(lastName);
        }
        if(email != null &&
            email.length() > 0 &&
            !Objects.equals(contact.getEmail(), email)) {
            Optional<Contact> contactOptional = contactRepository
                    .findContactByEmail(email);
            if(contactOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            contact.setEmail(email);
        }
    }
}
