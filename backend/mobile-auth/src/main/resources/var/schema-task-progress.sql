-- Apply to the shared SCM table. Review existing General In-Progress duplicates before applying.
-- Completion and other task types can still record activity on the same date.
ALTER TABLE Update_Todays_Progress ADD COLUMN scm_general_progress_day VARCHAR(10)
    GENERATED ALWAYS AS (CASE WHEN TASK_TYPE = 'General' AND STATUS = 'In-Progress' THEN DATE ELSE NULL END);
CREATE UNIQUE INDEX scm_daily_general_progress ON Update_Todays_Progress (TASK_ID, scm_general_progress_day);
