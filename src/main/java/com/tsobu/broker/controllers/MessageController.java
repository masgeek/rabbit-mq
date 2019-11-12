package com.tsobu.broker.controllers;

import com.tsobu.broker.entity.Order;
import com.tsobu.broker.service.OrderMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/api/v2/message")
@Controller
public class MessageController {
    private final OrderMessageSender orderMessageSender;

    @Autowired
    public MessageController(OrderMessageSender orderMessageSender) {
        this.orderMessageSender = orderMessageSender;
    }

    @PostMapping("/sendMsg")
    public String handleMessage(Order order, RedirectAttributes redirectAttributes) {
        orderMessageSender.sendOrder(order);
//        redirectAttributes.addFlashAttribute("message", "Order message sent successfully");
        return "redirect:/";
    }
}
