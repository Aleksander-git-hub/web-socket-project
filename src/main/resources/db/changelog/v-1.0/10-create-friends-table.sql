CREATE TABLE friends(
    user_id BIGINT REFERENCES users(id) ON DELETE RESTRICT,
    friend_id BIGINT REFERENCES users(id) ON DELETE RESTRICT
)