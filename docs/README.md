# User Guide

## Features 

### 1. Add Todo
Add a todo task to your task list.

### 2. Add Deadline
Add a deadline task to your task list with relevant time.

### 3. Add Event
Add an event to your task list with relevant time.

### 4. Mark task as Done
Mark a task in your task list as done.

### 5. List all tasks
List out all tasks in your task list in order.

### 6. Delete task
Delete a task from your task list.

### 7. Find task
Find tasks containing any form of a keyword.

### 8. Save task list
Save your task list to a .txt file.

### 8. Save task list
Load your task list from a .txt file.


## Usage

### Loading from txt file
When the Program is started, it automatically looks for its backup file at data/duke.txt. If it is not found it will be created.

**Example of usage:**
No previous backup found:

    File not found. New file created
    File loaded successfully.
Backup found, writing to backup:

    File loaded successfully.
    
 list

    Here are the tasks in your list: 
    1. [T][✓] read book 
    2. [E][✘] meeting (10am) 
    3. [D][✘] Assignment 2 (Monday 2359)    

### `todo <task description>` - Add a Todo task

Add a Todo task to your task list.

Example of usage:

`todo read book`

Expected outcome:


    Got it. I've added this task: 
    [T][✗] read book`
    Now you have 1 tasks in the list.


### `event <task description> /at <date>` - Add an Event

Add an Event task to your task list with relevant time.

Example of usage:

    event meeting /10am

Expected outcome:
    Got it. I've added this task: 
    [E][✘] meeting (10am)
    Now you have 2 tasks in the list.


### `deadline <task description> /by <date>` - Add a Deadline

Add a Deadline task to your task list.

Example of usage:

`deadline Assignment 2 /Monday 2359`

Expected outcome:

    Got it. I've added this task: 
    [D][✗] Assignment 2 (Monday 2359)
    Now you have 3 tasks in the list.

### `done <task index>` - Mark task as done

Mark a task in your task list as done.

Example of usage:

    done 1

Expected outcome:

    Nice! I've marked this task as done: 
    [T][✓] read book

### `list` - List all tasks

List all tasks in your task list.

Example of usage:

`list`

Expected outcome:


    Here are the tasks in your list: 
    1. [T][✓] read book
    2. [E][✘] meeting (10am)
    3. [D][✘] Assignment 2 (Monday 2359)

### `delete <task index>` - Delete a task
 
Delete a task from your task list.

Example of usage:

`delete 1`

Expected outcome:


    Removed: [T][✓] read book
    Now you have 2 task(s) in your list


### `find <keyword>` - Find tasks

Find tasks with matching keyword. Even tasks that have different workings than the keywork can turn up.

Example of usage:

    find read

Expected outcome:

    Here are the matching tasks in your list: 
    1. [D][✘] Go through lecture readings (Tuesday before lecture)
    2. [E][✘] I hate reading (Tuesday 10pm)


### `save` - Save task list

Save task list to .txt file.

Example of usage:

`save`

Expected outcome:

    Successfully saved to file!
