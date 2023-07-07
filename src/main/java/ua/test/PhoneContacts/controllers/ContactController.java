package ua.test.PhoneContacts.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ua.test.PhoneContacts.exceptions.ContactErrorResponse;
import ua.test.PhoneContacts.exceptions.ContactNotAddedOrUpdatedException;
import ua.test.PhoneContacts.models.Contact;
import ua.test.PhoneContacts.services.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public List<Contact> getContacts(){
        return contactService.showAllContacts();
    }

    @GetMapping("/{id}")
    public Contact findById(@PathVariable int id){
        return contactService.findById(id);
    }


    @PostMapping
    public ResponseEntity<HttpStatus> addNewContact(@RequestBody @Valid Contact contact,
                                                    BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            throw new ContactNotAddedOrUpdatedException(errorMsg.toString());
        }
        contactService.save(contact);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ContactErrorResponse> handleException(ContactNotAddedOrUpdatedException e){
        ContactErrorResponse response = new ContactErrorResponse(
            e.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable int id,
            @RequestBody @Valid Contact contact, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            throw new ContactNotAddedOrUpdatedException(errorMsg.toString());
        }

        contactService.update(id, contact);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        contactService.delete(id);
    }

}
