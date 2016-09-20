package ru.quasistellar.messages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
public class MessageAdminController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private MailMessage ms;

    @RequestMapping(value="/admin/clients", method = RequestMethod.GET)
    public String adminMessages(Model model) {
        model.addAttribute("messages", messageService.all());
        return "admin/message/message";
    }

    @RequestMapping(value="/savemessages", method = RequestMethod.POST)

    public @ResponseBody String saveMessages(Message message) {

                message = messageService.create(message);
                ms.sendM(message.getName(), message.getEmail(), message.getTel(), message.getContent());
                return "OK";

    }



    @RequestMapping(value="/admin/clients/{messageId}", method = RequestMethod.GET)
    public String messageEdit(@PathVariable("messageId") Integer messageId,  Model model) {
        model.addAttribute("message", messageService.find(messageId));
        return "admin/message/edit";
    }

    @RequestMapping(value="/admin/clients/del/{messageId}", method = RequestMethod.POST)
    public String messageDelete(@PathVariable("messageId") Integer messageId) {
       messageService.delete(messageId);
        return "redirect:/admin/clients";
    }


    }

