
---

## **Question**

You are developing a file size calculator for a cloud storage system. The system needs to calculate the total size of a directory, which may contain files and subdirectories.

  

Given the directory structure:

```
project/
├── src/
│   ├── main.java (100 KB)
│   └── utils.java (50 KB)
├── docs/
│   ├── readme.txt (10 KB)
│   └── guides/
│       └── setup.pdf (200 KB)
└── config.xml (20 KB)
```

Answer the following:

  

**a)** Design a recursive function (pseudocode) to calculate total directory size. Identify base and recursive cases.

**b)** Trace the execution and show the call stack and returned values.

**c)** Find the time complexity.

**d)** Can it be solved iteratively? Compare both approaches.

**e)** What if a symbolic link creates a cycle? How will you handle it?

---

## **Solution**

  

### **a) Recursive Function Design**

  

**Pseudocode:**

```
function getSize(node):
    if node is a file:
        return node.size        // Base case

    total = 0
    for each child in node:
        total = total + getSize(child)   // Recursive case
    return total
```

**Base Case:**

- When the node is a file, return its size.
    

  

**Recursive Case:**

- When the node is a directory, recursively compute size of all children.
    

---

### **b) Execution Trace**

```
getSize(project)
 ├── getSize(src)
 │    ├── getSize(main.java) → 100
 │    └── getSize(utils.java) → 50
 │    src returns 150
 ├── getSize(docs)
 │    ├── getSize(readme.txt) → 10
 │    └── getSize(guides)
 │         └── getSize(setup.pdf) → 200
 │         guides returns 200
 │    docs returns 210
 └── getSize(config.xml) → 20
project returns 380 KB
```

**Total Directory Size = 380 KB**

---

### **c) Time Complexity**

  

Let **N** be total files and directories.

  

\text{Time Complexity} = O(N)

  

Each file and directory is visited once.

---

### **d) Iterative Solution**

  

Yes, it can be solved iteratively.

  

**Data Structure Used:**

- Stack (DFS) or Queue (BFS)
    

  

**Comparison:**

|**Recursive**|**Iterative**|
|---|---|
|Simple to write|Avoids stack overflow|
|Uses call stack|Uses explicit stack|
|Risky for deep trees|Safer for large systems|

---

### **e) Symbolic Link Cycle Problem**

  

**Issue:**

- Cycles cause infinite recursion.
    

  

**Solution:**

- Maintain a visited set.
    
- If a directory is already visited, return 0.
    

  

This prevents infinite loops.

---
