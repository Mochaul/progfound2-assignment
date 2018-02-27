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
5. [Attributions](#attributions)
6. [License](#license)

## Initial Setup

1. Create a new GitLab project for storing all tutorial work, e.g.
`ProgFound2 Assignments`. **The new GitLab project you just created
along with its repository will be used to store your source code
related to assignments.**
2. Open the project page and copy the HTTPS clone URL into clipboard
3. Clone the repository into your local machine. Use Git command:
`git clone https://gitlab.com/<YOURNAME>/progfound2-assignments.git <PATH>`
where `<PATH>` is a path to a directory in your local machine.
4. Go to the directory where the cloned repository is located in your
local machine.
5. Add new remote called **upstream** that points to this (assignment)
repository. Use Git command: `git remote add upstream https://gitlab.com/ddp2-csui/assignment.git`
6. Pull initial problem sets from `upstream` to your local's `master`:
`git pull upstream master`
7. Push initial commits in your local's `master` to your online GitLab
repository: `git push -u origin master`
8. Ensure that your repository page has visibility level set to
**Private**. Check it in **Edit Project** menu at your repository page.
9. Contact your TA and invite him/her to become a member in your new
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
your repository on GitLab, do a Git push. The Git command: 
`git push -u origin master`

## Pulling Updates From Upstream

If there are any updates from upstream, you can get the latest commits
and integrate it into your Git repository. by using the following Git
command: `git pull upstream master`

Merge conflicts may arise since the repository is updated regularly and
may have overlapping changes with the `master` branch in your own
forked repository. If merge conflict happens, please always use latest
commit from `upstream`. Your works are safe as long you put in in its
own separate branches, e.g. `assignment-1`, `assignment-2`, and so forth.

Once you have resolved any merge conflicts and all commits from
upstream are merged succesfully to your own `master` branch, do not
forget to push it back to your own GitLab repository. Use Git command:
`git push origin master`

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
