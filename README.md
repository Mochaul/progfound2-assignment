# Assignments Repository

CSGE601021 Programming Foundations 2 @ Faculty of Computer Science Universitas
Indonesia, Term 2 2017/2018

* * *

## Table of Contents

1. Problem Sets
    1. [Assignment 1: Train to Javari Park](assignment-1/README.md)
    2. [Assignment 2: TBD](#)
    3. [Assignment 3: TBD](#)
    4. [Assignment 4: TBD](#)
    5. [Assignment 5: TBD](#)
2. [Initial Setup](#initial-setup)
3. [Working on the Assignment](#working-on-the-assignment)
4. [Pulling Updates from Upstream](#pulling-updates-from-upstream)
5. [Contact Information](#contact-information)
6. [Attributions](#attributions)
7. [License](#license)

## Initial Setup

1. Create a new GitLab project for storing all assignment work, e.g.
`ProgFound2-Assignments` 

    > Note: The new GitLab project you just created along with its repository
    > will be used to store your source code related to assignments.
2. Open the new project page and take note of the HTTPS clone URL, either
by writing it down to paper/digital file or copying it to clipboard

    > Note: Assuming your new project is named `ProgFound2-Assignments`, the
    > following is the clone URL of your Git repository on GitLab:
    > `https://gitlab.com/<YOURNAME>/ProgFound2-Assignments.git`
3. Open your favourite terminal/shell in your local machine and navigate
to a directory where you will clone the empty, new repository from your online
repository on GitLab

    > Note: The following commands might be helpful when you have to navigate
    > and manage files/folders using shell:
    >
    > - `cd` (change active directory to a specified directory)
    > - `mkdir` (make new directory in currently active directory)
    > - `rm`/`del` (delete a file)
    > - `ls`/`dir` (list files & folders in current active directory)
4. Clone the repository into your local machine using `git clone` command

    ```bash
    # Example:
    $ git clone https://gitlab.com/<YOURNAME>/ProgFound2-Assignments.git <PATH>
    Cloning into 'ProgFound2-Assignments'
    warning: You appear to have cloned an empty repository
    ```
    > Note: `<PATH>` is a path to a directory in your machine. It can be empty,
    > thus telling Git to create a new directory with the same name as your
    > repository and copy your online Git repository into the new directory
5. Change your active directory into the directory where the cloned repository
is located and try to call `git status` command in the directory

    ```bash
    # Example:
    $ cd ProgFound2-Assignments
    $ git status
    On branch master

    No commits yet

    nothing to commit (create/copy files and use "git add" to track)
    ```
6. Add new remote called `upstream` that points to the [Assignments Repository][4],
which is the GitLab project that contains the problem set description and starter
code

    ```bash
    # Example:
    $ git remote add upstream https://gitlab.com/DDP2-CSUI/assignment.git
    ```
    > Note: A Git remote is a pair of alias and URL (link) to another Git
    > repository. By default, your freshly cloned local Git repository will
    > have a remote named `origin` that points to your online Git repository
    > at GitLab. The example above tells your local Git repository to track
    > another *remote* Git repository located at
    > `http://gitlab.com/DDP2-CSUI/assignment.git` and name it as `upstream`
7. Get latest commits from `upstream` and merge it into your own local
repository by using `git pull` command

    ```bash
    # Example:
    $ git pull upstream master
    remote: Counting objects: 42, done.
    remote: Compressing objects: 100% (37/37), done.
    remote: Total 42 (delta 7), reused 0 (delta 0)
    Unpacking objects: 100% (42/42), done.
    From gitlab.com:DDP2-CSUI/assignment
     * branch            master     -> FETCH_HEAD
     * [new branch]      master     -> upstream/master
    ```
8. Synchronise commits from your local repository to your online Git repository
on GitLab by using `git push` command

    ```bash
    # Example:
    $ git push origin master
    Counting objects: 42, done.
    Delta compression using up to 8 threads.
    Compressing objects: 100% (37/37), done.
    Writing objects: 100% (42/42), 36.12 KiB | 1.57 MiB/s, done.
    Total 42 (delta 7), reused 0 (delta 0)
    To gitlab.com:<YOURNAME>/ProgFound2-Assignments.git
     * [new branch]      master -> master
    ```
9. Verify that the commits from `upstream` are now present in your own GitLab
project by checking the project page on GitLab
10. Ensure that your repository page has visibility level set to
**Private**. Check it in **Edit Project** menu at your repository page.
11. Contact your TA and invite him/her to become a member in your new
GitLab project as a **Master**

## Working on the Assignment

1. Suppose that you want to work on assignment 1. Go to the
directory that containing assignment 1 problem, i.e. `assignment-1`.
2. Read the README file in `assignment-1` directory
3. Do the assignment
4. Use `git add` or `git rm` to stage/unstage files that you want to
save into Git later
5. Once you want to save your progress, commit your work to Git. Use
Git command: `git commit` A text editor will apear where you should
write a commit message. Please try to follow the guidelines written
in [this guide](http://chris.beams.io/posts/git-commit/) on how to
write a good commit message
6. Repeat steps 3 - 5 until you finished the assignment
7. Once you are ready to submit your work or you want to save it to
your repository on GitLab, do a Git push

## Pulling Updates From Upstream

If there are any updates from `upstream`, you can get the latest commits
and integrate it into your local Git repository by using the following
Git command: `git pull upstream master`

Merge conflicts may arise since the repository is updated regularly and
may have overlapping changes with the `master` branch in your own
forked repository. If merge conflict happens, please always use latest
commit from `upstream`. Your works are safe as long you put in in its
own separate directory, e.g. `assignment-1`, `assignment-2`, and so forth.

Once you have resolved any merge conflicts and all commits from
`upstream` are merged succesfully to your own `master` branch, do not
forget to push it back to your own GitLab repository. Use Git command:
`git push origin master`

> Note: Please consult your TA if you have difficulty when resolving merge
> conflict(s).

## Contact Information

If you have questions or feedbacks related to the assignments, please contact
your lecturer and/or teaching assistants (TA). You can do so via the Issue
Tracker at the original [Assignments Repository][4] project on GitLab.

TA also maintains a LINE@ Account ([@nhz2170m][5]) that usually posts reminders,
tips, and jokes related to this course in Bahasa Indonesia. You can ask your
questions either in Bahasa Indonesia or English.

## Attributions

Gradle multi-project structure and the root (main) README file were based on
the same structure found in [tutorial repository for Advanced Programming][3]
course term 2 2017/2018.

## License

Copyright (c) 2018, Faculty of Computer Science Universitas Indonesia

Permission to copy, modify, and share the works in this project are governed
under two licenses: [BSD 3-Clause][1] and [Creative Commons Attribution-ShareAlike 4.0 (CC BY-SA 4.0)][2]
Unless noted otherwise, BSD 3-Clause applies to source code (e.g. Java, YML,
configuration files), while CC BY-SA 4.0 applies to text documents in this project.

[1]: LICENSE
[2]: https://creativecommons.org/licenses/by-sa/4.0/
[3]: https://gitlab.com/csui-advprog-2018/lab
[4]: https://gitlab.com/DDP2-CSUI/assignment
[5]: https://line.me/R/ti/p/%40nhz2170m)
