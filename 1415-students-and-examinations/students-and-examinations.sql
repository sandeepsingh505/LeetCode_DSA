# Write your MySQL query statement below
select students.student_id , students.student_name,subjects.subject_name,count(Examinations.Student_id) as attended_exams from Students
cross Join Subjects
Left Join Examinations on Subjects.subject_name = Examinations.subject_name And Students.student_id = Examinations.student_id Group By Students.Student_id,Students.Student_name,Subjects.Subject_name Order by Students.Student_id, Subjects.Subject_name;