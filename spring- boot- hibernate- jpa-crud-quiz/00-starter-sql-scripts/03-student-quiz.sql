CREATE DATABASE  IF NOT EXISTS `student_quiz`;
USE `student_quiz`;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `Topics`;
DROP TABLE IF EXISTS `Questions`;
DROP TABLE IF EXISTS `Responses`;

CREATE TABLE Topics (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE Questions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    topic_id INT,
    difficulty_rank INT,
    content TEXT NOT NULL,
    FOREIGN KEY (topic_id) REFERENCES Topics(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE Responses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    question_id INT,
    text TEXT NOT NULL,
    is_correct BOOLEAN,
    FOREIGN KEY (question_id) REFERENCES Questions(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

