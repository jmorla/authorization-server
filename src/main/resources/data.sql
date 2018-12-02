INSERT INTO USERS
  (USER_ID, USERNAME, PASSWORD)
VALUES
  ('bf14e0655b3648cd9afb166be1530000', 'admin', '$2a$10$zzk.UUvqJGOa.2ADJNlyiOFhTjpLn5wmo276n1pUCWwemWNHv6nD.'),
  ('4884d3296c8c4727827dd1d3b0770001', 'teacher', '$2a$10$TXJzACXFTS9JyXjGuuZJqOmlU4azIiZQQh63mxGpVrHrbXf5AkqjG');

INSERT INTO AUTHORITIES
  (AUTHORITY_ID, AUTHORITY_NAME, DESCRIPTION)
VALUES
  (1, 'administration-read', 'permission to read on administration domain'),
  (2, 'administration-write', 'permission to write on administration domain'),
  (3, 'logistic-read', 'permission to read on logistic domain'),
  (4, 'logistic-write', 'permission to write on logistic domain');

INSERT INTO AUTHORITIES_USERS
  (USER_ID, AUTHORITY_ID)
VALUES
  ('bf14e0655b3648cd9afb166be1530000', 1),
  ('bf14e0655b3648cd9afb166be1530000', 2),
  ('bf14e0655b3648cd9afb166be1530000', 3),
  ('bf14e0655b3648cd9afb166be1530000', 4),

  ('4884d3296c8c4727827dd1d3b0770001', 1),
  ('4884d3296c8c4727827dd1d3b0770001', 3);