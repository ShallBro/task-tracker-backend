create table tasks
(
    id          bigserial
        primary key,
    user_id     bigint                                 not null
        constraint fk_tasks_user
            references users
            on delete cascade,
    title       varchar(255)                           not null,
    description text,
    is_done     boolean                  default false not null,
    created_at  timestamp with time zone default now() not null,
    done_at     timestamp with time zone
);