INSERT INTO users (name, email, password, role, created_at) 
VALUES 
('Admin User', 'admin@nmscinemas.com', 'admin123', 'ADMIN', CURRENT_TIMESTAMP),
('John Doe', 'john.doe@example.com', 'password123', 'USER', CURRENT_TIMESTAMP),
('Jane Smith', 'jane.smith@example.com', 'password123', 'USER', CURRENT_TIMESTAMP),
('Alice Johnson', 'alice.johnson@example.com', 'password123', 'USER', CURRENT_TIMESTAMP),
('Bob Brown', 'bob.brown@example.com', 'password123', 'USER', CURRENT_TIMESTAMP);


INSERT INTO movies (title, genre, language, release_date, duration_minutes, description, poster_url, created_at) 
VALUES 
('Inception', 'SCIENCE_FICTION', 'ENGLISH', '2010-07-16', 148, 'A thief who enters the dreams of others to steal secrets from their subconscious.', 'https://upload.wikimedia.org/wikipedia/en/2/2e/Inception_%282010%29_theatrical_poster.jpg', CURRENT_TIMESTAMP),
('Interstellar', 'SCIENCE_FICTION', 'ENGLISH', '2014-11-07', 169, 'A team of explorers travel through a wormhole in space to ensure humanity''s survival.', 'https://upload.wikimedia.org/wikipedia/en/b/bc/Interstellar_film_poster.jpg', CURRENT_TIMESTAMP),
('Parasite', 'THRILLER', 'KOREAN', '2019-05-30', 132, 'A poor family schemes their way into the lives of a wealthy household.', 'https://upload.wikimedia.org/wikipedia/en/5/53/Parasite_%282019_film%29.png', CURRENT_TIMESTAMP),
('Joker', 'DRAMA', 'ENGLISH', '2019-10-04', 122, 'A mentally troubled comedian embarks on a downward spiral.', 'https://upload.wikimedia.org/wikipedia/en/e/e1/Joker_%282019_film%29_poster.jpg', CURRENT_TIMESTAMP),
('Spirited Away', 'ANIMATION', 'JAPANESE', '2001-07-20', 125, 'A girl wanders into a mysterious world ruled by spirits and gods.', 'https://upload.wikimedia.org/wikipedia/en/d/db/Spirited_Away_Japanese_poster.png', CURRENT_TIMESTAMP);

INSERT INTO theatres (name, location, capacity, created_at) 
VALUES 
('Regal Cinemas', 'London', 250, CURRENT_TIMESTAMP),
('Grand Theatre', 'Manchester', 300, CURRENT_TIMESTAMP),
('Empire Cinema', 'Liverpool', 180, CURRENT_TIMESTAMP),
('Odeon', 'Birmingham', 400, CURRENT_TIMESTAMP),
('Vue Cinema', 'Leeds', 220, CURRENT_TIMESTAMP);

INSERT INTO showtimes (movie_id, theatre_id, show_date, available_seats, created_at) 
VALUES 
(1, 1, '2025-02-01', 250, CURRENT_TIMESTAMP), -- Inception at Regal Cinemas
(1, 2, '2025-02-02', 300, CURRENT_TIMESTAMP), -- Inception at Grand Theatre
(2, 3, '2025-02-03', 180, CURRENT_TIMESTAMP), -- Interstellar at Empire Cinema
(2, 4, '2025-02-04', 400, CURRENT_TIMESTAMP), -- Interstellar at Odeon
(3, 5, '2025-02-05', 220, CURRENT_TIMESTAMP), -- Parasite at Vue Cinema
(3, 1, '2025-02-06', 250, CURRENT_TIMESTAMP), -- Parasite at Regal Cinemas
(4, 2, '2025-02-07', 300, CURRENT_TIMESTAMP), -- Joker at Grand Theatre
(4, 3, '2025-02-08', 180, CURRENT_TIMESTAMP), -- Joker at Empire Cinema
(5, 4, '2025-02-09', 400, CURRENT_TIMESTAMP), -- Spirited Away at Odeon
(5, 5, '2025-02-10', 220, CURRENT_TIMESTAMP); -- Spirited Away at Vue Cinema

INSERT INTO bookings (user_id, showtime_id, number_of_tickets, booked_at) 
VALUES 
-- Inception (Showtime 1, 2)
(2, 1, 2, CURRENT_TIMESTAMP), -- John Doe books 2 tickets for Inception at Regal Cinemas
(3, 1, 3, CURRENT_TIMESTAMP), -- Jane Smith books 3 tickets for Inception at Regal Cinemas
(4, 2, 2, CURRENT_TIMESTAMP), -- Alice Johnson books 2 tickets for Inception at Grand Theatre
(5, 2, 1, CURRENT_TIMESTAMP), -- Bob Brown books 1 ticket for Inception at Grand Theatre

-- Interstellar (Showtime 3, 4)
(3, 3, 1, CURRENT_TIMESTAMP), -- Jane Smith books 1 ticket for Interstellar at Empire Cinema
(4, 3, 2, CURRENT_TIMESTAMP), -- Alice Johnson books 2 tickets for Interstellar at Empire Cinema
(5, 4, 3, CURRENT_TIMESTAMP), -- Bob Brown books 3 tickets for Interstellar at Odeon
(2, 4, 2, CURRENT_TIMESTAMP), -- John Doe books 2 tickets for Interstellar at Odeon

-- Parasite (Showtime 5, 6)
(4, 5, 2, CURRENT_TIMESTAMP), -- Alice Johnson books 2 tickets for Parasite at Vue Cinema
(5, 5, 1, CURRENT_TIMESTAMP), -- Bob Brown books 1 ticket for Parasite at Vue Cinema
(2, 6, 3, CURRENT_TIMESTAMP), -- John Doe books 3 tickets for Parasite at Regal Cinemas
(3, 6, 2, CURRENT_TIMESTAMP), -- Jane Smith books 2 tickets for Parasite at Regal Cinemas

-- Joker (Showtime 7, 8)
(5, 7, 3, CURRENT_TIMESTAMP), -- Bob Brown books 3 tickets for Joker at Grand Theatre
(2, 7, 1, CURRENT_TIMESTAMP), -- John Doe books 1 ticket for Joker at Grand Theatre
(3, 8, 2, CURRENT_TIMESTAMP), -- Jane Smith books 2 tickets for Joker at Empire Cinema
(4, 8, 4, CURRENT_TIMESTAMP), -- Alice Johnson books 4 tickets for Joker at Empire Cinema

-- Spirited Away (Showtime 9, 10)
(2, 9, 5, CURRENT_TIMESTAMP), -- John Doe books 5 tickets for Spirited Away at Odeon
(3, 9, 2, CURRENT_TIMESTAMP), -- Jane Smith books 2 tickets for Spirited Away at Odeon
(4, 10, 1, CURRENT_TIMESTAMP), -- Alice Johnson books 1 ticket for Spirited Away at Vue Cinema
(5, 10, 3, CURRENT_TIMESTAMP); -- Bob Brown books 3 tickets for Spirited Away at Vue Cinema

