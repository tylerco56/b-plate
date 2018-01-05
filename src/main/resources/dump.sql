-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jan 04, 2018 at 08:45 PM
-- Server version: 5.6.35
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `b-plate`
--

-- --------------------------------------------------------

--
-- Table structure for table `page`
--

CREATE TABLE `page` (
  `id` bigint(20) NOT NULL,
  `body` longtext,
  `name` varchar(255) NOT NULL,
  `publish` bit(1) NOT NULL,
  `updated` tinyblob,
  `url` varchar(255) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `page`
--

INSERT INTO `page` (`id`, `body`, `name`, `publish`, `updated`, `url`, `author_id`) VALUES
  (1, '\n<!--Hero-->\n<div class=\"section no-pad-bot\" id=\"index-banner\">\n    <div class=\"container\">\n        <h1 class=\"text_h center header cd-headline letters type\">\n            <span>I Love</span>\n            <span class=\"cd-words-wrapper waiting\">\n                <b class=\"is-visible\">creating</b>\n                <b>designing</b>\n                <b>developing</b>\n            </span>\n        </h1>\n    </div>\n</div>\n\n<!--Intro and service-->\n<div id=\"intro\" class=\"section scrollspy\">\n    <div class=\"container\">\n        <div class=\"row\">\n            <div  class=\"col s12\">\n                <h2 class=\"center header text_h2\"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. <span class=\"span_h2\"> Phasellus  </span>vestibulum lorem risus, nec suscipit lorem <span class=\"span_h2\"> laoreet quis.</span> </h2>\n            </div>\n\n            <div  class=\"col s12 m4 l4\">\n                <div class=\"center promo promo-example\">\n                    <i class=\"mdi-image-flash-on\"></i>\n                    <h5 class=\"promo-caption\">Speeds up development</h5>\n                    <p class=\"light center\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Cum sociis natoque penatibus et magnis dis parturient montes.</p>\n                </div>\n            </div>\n            <div class=\"col s12 m4 l4\">\n                <div class=\"center promo promo-example\">\n                    <i class=\"mdi-social-group\"></i>\n                    <h5 class=\"promo-caption\">User Experience Focused</h5>\n                    <p class=\"light center\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>\n                </div>\n            </div>\n            <div class=\"col s12 m4 l4\">\n                <div class=\"center promo promo-example\">\n                    <i class=\"mdi-hardware-desktop-windows\"></i>\n                    <h5 class=\"promo-caption\">Fully responsive</h5>\n                    <p class=\"light center\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.</p>\n                </div>\n            </div>\n        </div>\n    </div>\n</div>\n\n<!--Work-->\n<div class=\"section scrollspy\" id=\"work\">\n    <div class=\"container\">\n        <h2 class=\"header text_b\">Work </h2>\n        <div class=\"row\">\n            <div class=\"col s12 m4 l4\">\n                <div class=\"card\">\n                    <div class=\"card-image waves-effect waves-block waves-light\">\n                        <img class=\"activator\" src=\"/assets/images/project1.jpg\">\n                    </div>\n                    <div class=\"card-content\">\n                        <span class=\"card-title activator grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-more-vert right\"></i></span>\n                        <p><a href=\"#\">Project link</a></p>\n                    </div>\n                    <div class=\"card-reveal\">\n                        <span class=\"card-title grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-close right\"></i></span>\n                        <p>Here is some more information about this project that is only revealed once clicked on.</p>\n                    </div>\n                </div>\n            </div>\n            <div class=\"col s12 m4 l4\">\n                <div class=\"card\">\n                    <div class=\"card-image waves-effect waves-block waves-light\">\n                        <img class=\"activator\" src=\"/assets/images/project2.jpeg\">\n                    </div>\n                    <div class=\"card-content\">\n                        <span class=\"card-title activator grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-more-vert right\"></i></span>\n                        <p><a href=\"#\">Project link</a></p>\n                    </div>\n                    <div class=\"card-reveal\">\n                        <span class=\"card-title grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-close right\"></i></span>\n                        <p>Here is some more information about this project that is only revealed once clicked on.</p>\n                    </div>\n                </div>\n            </div>\n            <div class=\"col s12 m4 l4\">\n                <div class=\"card\">\n                    <div class=\"card-image waves-effect waves-block waves-light\">\n                        <img class=\"activator\" src=\"/assets/images/project3.png\">\n                    </div>\n                    <div class=\"card-content\">\n                        <span class=\"card-title activator grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-more-vert right\"></i></span>\n                        <p><a href=\"#\">Project link</a></p>\n                    </div>\n                    <div class=\"card-reveal\">\n                        <span class=\"card-title grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-close right\"></i></span>\n                        <p>Here is some more information about this project that is only revealed once clicked on.</p>\n                    </div>\n                </div>\n            </div>\n            <div class=\"col s12 m4 l4\">\n                <div class=\"card\">\n                    <div class=\"card-image waves-effect waves-block waves-light\">\n                        <img class=\"activator\" src=\"/assets/images/project4.jpg\">\n                    </div>\n                    <div class=\"card-content\">\n                        <span class=\"card-title activator grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-more-vert right\"></i></span>\n                        <p><a href=\"#\">Project link</a></p>\n                    </div>\n                    <div class=\"card-reveal\">\n                        <span class=\"card-title grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-close right\"></i></span>\n                        <p>Here is some more information about this project that is only revealed once clicked on.</p>\n                    </div>\n                </div>\n            </div>\n            <div class=\"col s12 m4 l4\">\n                <div class=\"card\">\n                    <div class=\"card-image waves-effect waves-block waves-light\">\n                        <img class=\"activator\" src=\"/assets/images/project5.png\">\n                    </div>\n                    <div class=\"card-content\">\n                        <span class=\"card-title activator grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-more-vert right\"></i></span>\n                        <p><a href=\"#\">Project link</a></p>\n                    </div>\n                    <div class=\"card-reveal\">\n                        <span class=\"card-title grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-close right\"></i></span>\n                        <p>Here is some more information about this project that is only revealed once clicked on.</p>\n                    </div>\n                </div>\n            </div>\n            <div class=\"col s12 m4 l4\">\n                <div class=\"card\">\n                    <div class=\"card-image waves-effect waves-block waves-light\">\n                        <img class=\"activator\" src=\"/assets/images/project6.jpeg\">\n                    </div>\n                    <div class=\"card-content\">\n                        <span class=\"card-title activator grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-more-vert right\"></i></span>\n                        <p><a href=\"#\">Project link</a></p>\n                    </div>\n                    <div class=\"card-reveal\">\n                        <span class=\"card-title grey-text text-darken-4\">Project Title <i class=\"mdi-navigation-close right\"></i></span>\n                        <p>Here is some more information about this project that is only revealed once clicked on.</p>\n                    </div>\n                </div>\n            </div>\n        </div>\n    </div>\n</div>\n\n<!--Parallax-->\n<div class=\"parallax-container\">\n    <div class=\"parallax\"><img src=\"/assets/images/parallax1.png\"></div>\n</div>\n\n<!--Team-->\n<div class=\"section scrollspy\" id=\"team\">\n    <div class=\"container\">\n        <h2 class=\"header text_b\"> Our Team </h2>\n        <div class=\"row\">\n            <div class=\"col s12 m3\">\n                <div class=\"card card-avatar\">\n                    <div class=\"waves-effect waves-block waves-light\">\n                        <img class=\"activator\" src=\"/assets/images/avatar1.png\">\n                    </div>\n                    <div class=\"card-content\">\n                        <span class=\"card-title activator grey-text text-darken-4\">Flash <br/>\n                            <small><em><a class=\"red-text text-darken-1\" href=\"#\">CEO</a></em></small></span>\n                        <p>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://www.facebook.com/joash.c.pereira\">\n                                <i class=\"fa fa-facebook-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://twitter.com/im_joash\">\n                                <i class=\"fa fa-twitter-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://plus.google.com/u/0/+JoashPereira\">\n                                <i class=\"fa fa-google-plus-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://www.linkedin.com/in/joashp\">\n                                <i class=\"fa fa-linkedin-square\"></i>\n                            </a>\n                        </p>\n                    </div>\n                </div>\n            </div>\n            <div class=\"col s12 m3\">\n                <div class=\"card card-avatar\">\n                    <div class=\"waves-effect waves-block waves-light\">\n                        <img class=\"activator\" src=\"/assets/images/avatar2.png\">\n                    </div>\n                    <div class=\"card-content\">\n                        <span class=\"card-title activator grey-text text-darken-4\">Cat Woman<br/>\n                            <small><em><a class=\"red-text text-darken-1\" href=\"#\">Designer</a></em></small>\n                        </span>\n                        <p>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://www.facebook.com/joash.c.pereira\">\n                                <i class=\"fa fa-facebook-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://twitter.com/im_joash\">\n                                <i class=\"fa fa-twitter-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://plus.google.com/u/0/+JoashPereira\">\n                                <i class=\"fa fa-google-plus-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://www.linkedin.com/in/joashp\">\n                                <i class=\"fa fa-linkedin-square\"></i>\n                            </a>\n                        </p>\n                    </div>\n                </div>\n            </div>\n            <div class=\"col s12 m3\">\n                <div class=\"card card-avatar\">\n                    <div class=\"waves-effect waves-block waves-light\">\n                        <img class=\"activator\" src=\"/assets/images/avatar3.png\">\n                    </div>\n                    <div class=\"card-content\">\n                        <span class=\"card-title activator grey-text text-darken-4\">\n                            Capt. America <br/>\n                            <small><em><a class=\"red-text text-darken-1\" href=\"#\">CMO</a></em></small></span>\n                        <p>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://www.facebook.com/joash.c.pereira\">\n                                <i class=\"fa fa-facebook-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://twitter.com/im_joash\">\n                                <i class=\"fa fa-twitter-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://plus.google.com/u/0/+JoashPereira\">\n                                <i class=\"fa fa-google-plus-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://www.linkedin.com/in/joashp\">\n                                <i class=\"fa fa-linkedin-square\"></i>\n                            </a>\n                        </p>\n                    </div>\n                </div>\n            </div>\n            <div class=\"col s12 m3\">\n                <div class=\"card card-avatar\">\n                    <div class=\"waves-effect waves-block waves-light\">\n                        <img class=\"activator\" src=\"/assets/images/avatar4.png\">\n                    </div>\n                    <div class=\"card-content\">\n                        <span class=\"card-title activator grey-text text-darken-4\">Robin<br/>\n                            <small><em><a class=\"red-text text-darken-1\" href=\"#\">Developer</a></em></small></span>\n                        <p>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://www.facebook.com/joash.c.pereira\">\n                                <i class=\"fa fa-facebook-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://twitter.com/im_joash\">\n                                <i class=\"fa fa-twitter-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://plus.google.com/u/0/+JoashPereira\">\n                                <i class=\"fa fa-google-plus-square\"></i>\n                            </a>\n                            <a class=\"blue-text text-lighten-2\" href=\"https://www.linkedin.com/in/joashp\">\n                                <i class=\"fa fa-linkedin-square\"></i>\n                            </a>\n                        </p>\n                    </div>\n                </div>\n            </div>\n        </div>\n    </div>\n</div>', 'home', b'1', NULL, 'index', 2),
  (2, '\n\n  <div id=\"index-banner\" class=\"parallax-container\">\n    <div class=\"section no-pad-bot\">\n      <div class=\"container\">\n        <br><br>\n        <h1 class=\"header center teal-text text-lighten-2\">Parallax Template</h1>\n        <div class=\"row center\">\n          <h5 class=\"header col s12 light\">A modern responsive front-end framework based on Material Design</h5>\n        </div>\n        <div class=\"row center\">\n          <a href=\"https://materializecss.com/getting-started.html\" id=\"download-button\" class=\"btn-large waves-effect waves-light teal lighten-1\">Get Started</a>\n        </div>\n        <br><br>\n\n      </div>\n    </div>\n    <div class=\"parallax\"><img src=\"/assets/images/background1.jpg\" alt=\"Unsplashed background img 1\"></div>\n  </div>\n\n\n  <div class=\"container\">\n    <div class=\"section\">\n\n      <!--   Icon Section   -->\n      <div class=\"row\">\n        <div class=\"col s12 m4\">\n          <div class=\"icon-block\">\n            <h2 class=\"center brown-text\"><i class=\"material-icons\">flash_on</i></h2>\n            <h5 class=\"center\">Speeds up development</h5>\n\n            <p class=\"light\">We did most of the heavy lifting for you to provide a default stylings that incorporate our custom components. Additionally, we refined animations and transitions to provide a smoother experience for developers.</p>\n          </div>\n        </div>\n\n        <div class=\"col s12 m4\">\n          <div class=\"icon-block\">\n            <h2 class=\"center brown-text\"><i class=\"material-icons\">group</i></h2>\n            <h5 class=\"center\">User Experience Focused</h5>\n\n            <p class=\"light\">By utilizing elements and principles of Material Design, we were able to create a framework that incorporates components and animations that provide more feedback to users. Additionally, a single underlying responsive system across all platforms allow for a more unified user experience.</p>\n          </div>\n        </div>\n\n        <div class=\"col s12 m4\">\n          <div class=\"icon-block\">\n            <h2 class=\"center brown-text\"><i class=\"material-icons\">settings</i></h2>\n            <h5 class=\"center\">Easy to work with</h5>\n\n            <p class=\"light\">We have provided detailed documentation as well as specific code examples to help new users get started. We are also always open to feedback and can answer any questions a user may have about Materialize.</p>\n          </div>\n        </div>\n      </div>\n\n    </div>\n  </div>\n\n\n  <div class=\"parallax-container valign-wrapper\">\n    <div class=\"section no-pad-bot\">\n      <div class=\"container\">\n        <div class=\"row center\">\n          <h5 class=\"header col s12 light\">A modern responsive front-end framework based on Material Design</h5>\n        </div>\n      </div>\n    </div>\n    <div class=\"parallax\"><img src=\"/assets/images/background2.jpg\" alt=\"Unsplashed background img 2\"></div>\n  </div>\n\n  <div class=\"container\">\n    <div class=\"section\">\n\n      <div class=\"row\">\n        <div class=\"col s12 center\">\n          <h3><i class=\"mdi-content-send brown-text\"></i></h3>\n          <h4>Contact Us</h4>\n          <p class=\"left-align light\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam scelerisque id nunc nec volutpat. Etiam pellentesque tristique arcu, non consequat magna fermentum ac. Cras ut ultricies eros. Maecenas eros justo, ullamcorper a sapien id, viverra ultrices eros. Morbi sem neque, posuere et pretium eget, bibendum sollicitudin lacus. Aliquam eleifend sollicitudin diam, eu mattis nisl maximus sed. Nulla imperdiet semper molestie. Morbi massa odio, condimentum sed ipsum ac, gravida ultrices erat. Nullam eget dignissim mauris, non tristique erat. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;</p>\n        </div>\n      </div>\n\n    </div>\n  </div>\n\n\n  <div class=\"parallax-container valign-wrapper\">\n    <div class=\"section no-pad-bot\">\n      <div class=\"container\">\n        <div class=\"row center\">\n          <h5 class=\"header col s12 light\">A modern responsive front-end framework based on Material Design</h5>\n        </div>\n      </div>\n    </div>\n    <div class=\"parallax\"><img src=\"/assets/images/background3.jpg\" alt=\"Unsplashed background img 3\"></div>\n  </div>\n', 'contact', b'1', NULL, 'contact', 1);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
  (1, 'ROLE_USER'),
  (2, 'ROLE_PUBLISHER'),
  (3, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `id` bigint(20) NOT NULL,
  `complete` bit(1) NOT NULL,
  `creation_date` tinyblob,
  `description` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`id`, `complete`, `creation_date`, `description`, `user_id`) VALUES
  (1, b'0', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770e05000007e10c1b121c1f01406f4078, 'Create your first task', 1),
  (2, b'0', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770e05000007e10c1b121c1f01406f4078, 'Create your first task', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `creation_date` tinyblob,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_login` tinyblob,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `reset_token` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `verify_password` varchar(100) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `creation_date`, `email`, `enabled`, `first_name`, `last_login`, `last_name`, `password`, `phone_number`, `reset_token`, `username`, `verify_password`, `role_id`) VALUES
  (1, NULL, 'you@youremail.com', b'1', 'First', NULL, 'Last', '$2a$10$j49FuG2CNUQg1N65FPYamOKTjaOTqG5Je38U3UKUI37borwVNcVDS', '1234567890', NULL, 'user', '$2a$10$j49FuG2CNUQg1N65FPYamOKTjaOTqG5Je38U3UKUI37borwVNcVDS', 1),
  (2, NULL, 'yous@youremail.com', b'1', 'First', NULL, 'Last', '$2a$10$j49FuG2CNUQg1N65FPYamOKTjaOTqG5Je38U3UKUI37borwVNcVDS', '1234567890', NULL, 'user2', '$2a$10$j49FuG2CNUQg1N65FPYamOKTjaOTqG5Je38U3UKUI37borwVNcVDS', 3);

-- --------------------------------------------------------

--
-- Table structure for table `verification_token`
--

CREATE TABLE `verification_token` (
  `id` bigint(20) NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `page`
--
ALTER TABLE `page`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_f6ctahf1jnokrtpp5wblm0shb` (`url`),
  ADD KEY `FK9clr2phrc7kt1psojjt29k43n` (`author_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2hsytmxysatfvt0p1992cw449` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  ADD KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`);

--
-- Indexes for table `verification_token`
--
ALTER TABLE `verification_token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrdn0mss276m9jdobfhhn2qogw` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `page`
--
ALTER TABLE `page`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `verification_token`
--
ALTER TABLE `verification_token`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `page`
--
ALTER TABLE `page`
  ADD CONSTRAINT `FK9clr2phrc7kt1psojjt29k43n` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `FK2hsytmxysatfvt0p1992cw449` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Constraints for table `verification_token`
--
ALTER TABLE `verification_token`
  ADD CONSTRAINT `FKrdn0mss276m9jdobfhhn2qogw` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
