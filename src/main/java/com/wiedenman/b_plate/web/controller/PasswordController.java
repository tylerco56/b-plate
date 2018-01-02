package com.wiedenman.b_plate.web.controller;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import com.wiedenman.b_plate.exception.EmailExistsException;
import com.wiedenman.b_plate.exception.UsernameExistsException;
import com.wiedenman.b_plate.service.UserService;
import com.wiedenman.b_plate.web.model.User;
import com.wiedenman.b_plate.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *    888                      888          888
 *    888                      888          888
 *    888                      888          888
 *    88888b.         88888b.  888  8888b.  888888 .d88b.
 *    888 "88b        888 "88b 888     "88b 888   d8P  Y8b
 *    888  888 888888 888  888 888 .d888888 888   88888888
 *    888 d88P        888 d88P 888 888  888 Y88b. Y8b.
 *    88888P"         88888P"  888 "Y888888  "Y888 "Y8888
 *                    888
 *                    888
 *                    888
 *
 *
 * @author Landon Wiedenman
 * github.com/landongw/b-plate
 * Usage: or personal non-commercial use only.  Please contact me for commercial uses.
 *
 * Copyright (c) 2017 Landon Wiedenman
 */

@Controller
public class PasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // Display forgotPassword page
    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public ModelAndView displayForgotPasswordPage() {
        return new ModelAndView("forgotPassword");
    }

    // Process form submission from forgotPassword page
    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public ModelAndView processForgotPasswordForm(ModelAndView modelAndView,
                                                  @RequestParam String userEmail,
                                                  HttpServletRequest request) throws EmailExistsException, UsernameExistsException {

        // Lookup user in database by e-mail
        User user = userService.findUserByEmail(userEmail);

        if (user == null) {
            // TODO: pass this error to the view
            modelAndView.addObject("errorMessage", "We didn't find an account for that e-mail address.");
        } else {

            // Generate random token to reset password
            user.setResetToken(UUID.randomUUID().toString());

            // Save token to database
            userService.save(user);

            String appUrl = request.getScheme() + "://" + request.getServerName();

            // Email message
            SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
            passwordResetEmail.setFrom("donotreply@b-plate.com");
            passwordResetEmail.setTo(user.getEmail());
            passwordResetEmail.setSubject("Password Reset Request");
            passwordResetEmail.setText("To reset your password, click the link:\n" + appUrl
                    + ":8080/reset?token=" + user.getResetToken());

            emailService.sendEmail(passwordResetEmail);

            // Add success message to view
            modelAndView.addObject("successMessage", "A password reset link has been sent to " + userEmail);
        }

        modelAndView.setViewName("forgotPassword");
        return modelAndView;

    }

    // Display form to reset password
    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {

        Optional<User> user = userService.findByResetToken(token);

        if (user.isPresent()) { // Token found in DB
            modelAndView.addObject("resetToken", token);
        } else { // Token not found in DB
            modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
        }

        modelAndView.setViewName("resetPassword");
        return modelAndView;
    }

    // Process reset password form
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public ModelAndView setNewPassword(ModelAndView modelAndView,
                                       @RequestParam Map<String,
                                       String> requestParams,
                                       @RequestParam String token,
                                       RedirectAttributes redir) throws EmailExistsException, UsernameExistsException {

        // Find the user associated with the reset token
        Optional<User> user = userService.findByResetToken(token);

        // This should always be non-null but we check just in case
        if (user.isPresent()) {

            User resetUser = user.get();

            // Set new password
            resetUser.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

            // Set the reset token to null so it cannot be used again
            resetUser.setResetToken(null);

            // Save user
            userService.save(resetUser);

            // TODO: make redirect attribute show up on flash in loginPage.html
            redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");

            modelAndView.setViewName("redirect:login");
            return modelAndView;

        } else {
            modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.  That's weird.");
            modelAndView.setViewName("resetPassword");
        }

        return modelAndView;
    }

    // Attempt to visit reset page without a token redirects to login page
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
        return new ModelAndView("redirect:login");
    }

    @RequestMapping(value = "/triggerPasswordReset", method = RequestMethod.POST)
    public ModelAndView triggerPasswordReset(@RequestParam String userEmail,
                                             ModelAndView modelAndView,
                                             HttpServletRequest request) throws EmailExistsException, UsernameExistsException {

        // Lookup user in database by e-mail
        User user = userService.findUserByEmail(userEmail);

        if (user == null) {
            // TODO: pass this error to the view
            modelAndView.addObject("errorMessage", "We didn't find an account for that e-mail address.");
        } else {

            // Generate random token to reset password
            user.setResetToken(UUID.randomUUID().toString());

            // Save token to database
            userService.save(user);

            String appUrl = request.getScheme() + "://" + request.getServerName();

            // Email message
            SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
            passwordResetEmail.setFrom("donotreply@b-plate.com");
            passwordResetEmail.setTo(user.getEmail());
            passwordResetEmail.setSubject("Password Reset Request");
            passwordResetEmail.setText("To reset your password, click the link:\n" + appUrl
                    + ":8080/reset?token=" + user.getResetToken());

            emailService.sendEmail(passwordResetEmail);

            // Pass user and title back to view
            modelAndView.addObject("user", user);
            modelAndView.addObject("title", "EDIT USER");
        }

        modelAndView.setViewName("user/edit");
        return modelAndView;

    }
}
