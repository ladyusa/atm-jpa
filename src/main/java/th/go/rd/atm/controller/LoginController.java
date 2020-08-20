package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.go.rd.atm.model.Customer;
import th.go.rd.atm.service.BankAccountService;
import th.go.rd.atm.service.CustomerService;

@Controller
@RequestMapping("/login")
public class LoginController {

    private CustomerService customerService;
    private BankAccountService bankAccountService;

    public LoginController(CustomerService customerService, BankAccountService bankAccountService) {
        this.customerService = customerService;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping()
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute Customer customer, Model model) {
        Customer storedCustomer = customerService.checkPin(customer);

        if (storedCustomer != null) {
            customer.setPin("");
            customer.setName(storedCustomer.getName());
            model.addAttribute("customer", customer);
            model.addAttribute("customermessage", customer.getName() + " Bank Accounts");
            model.addAttribute("bankaccounts", bankAccountService.getBankAccount(customer.getId()));
            return "bankaccount";
        } else {
            model.addAttribute("greeting", "Can't find customer");
            return "home";
        }
    }
}
