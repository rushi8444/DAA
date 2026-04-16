def job_sequencing(jobs):
    jobs.sort(key=lambda x: x[2], reverse=True)

    max_deadline = max(jobs, key=lambda x: x[1])[1]
    slots = [-1] * max_deadline

    total_profit = 0

    for job in jobs:
        for j in range(job[1]-1, -1, -1):
            if slots[j] == -1:
                slots[j] = job[0]
                total_profit += job[2]
                break

    print("Job sequence:", [j for j in slots if j != -1])
    print("Total profit:", total_profit)


jobs = [
    ('J1', 2, 20),
    ('J2', 2, 60),
    ('J3', 1, 40),
    ('J4', 3, 100),
    ('J5', 4, 80)
]

job_sequencing(jobs)