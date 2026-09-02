# Improved V-Method Testing Tool

## Overview

This tool supports specification-based testing based on the Improved V-Method for SOFL formal specifications. Its primary purpose is to automatically generate test data from formal test conditions derived from a specification.

The tool extracts functional scenarios and atomic predicates from a SOFL specification, applies the Vibration Method to generate test data around selected constraints, and presents the generated test cases through a graphical user interface. It also supports Java source import, theorem-related testing functions, and saving generated test data for later analysis.

This version extends the original V-Method prototype by improving the range of supported expressions and the handling of test conditions containing different SOFL data types and operators.

\---

## Main Features

### 1\. SOFL Specification Processing

* Imports SOFL specification files.
* Reads Functional Scenario Form (FSF) associated with a specification process.
* Extracts Test Conditions (TCs) and their Atomic Predicates (APs).
* Displays the structure of the loaded specification through the GUI.

### 2\. Automatic Test-Data Generation

* Generates test data from a selected Test Condition.
* Generates test data from an individual Atomic Predicate.
* Applies the Vibration Method to generate values at specified distances from constraint boundaries.
* Allows users to configure:

  * the number of generated test cases;
  * vibration distance;
  * distance increment;
  * other generation-related settings.

### 3\. Supported Expression Categories

The improved tool supports test-data generation for a variety of SOFL expression categories, including:

* Numeric expressions
* Sequence expressions
* Set expressions
* Composite-type expressions
* Conjunctions containing multiple Atomic Predicates
* Selected combinations of SOFL operators and arithmetic expressions

### 4\. Distance-Based Test Generation

The Vibration Method generates test data according to the distance between a generated value and a constraint boundary.

For example, given:

```text
x > 10
```

the tool can generate test values at user-defined distances from the boundary value `10`.

The distance settings can be configured through the **Setting** interface. Depending on the selected data type and expression structure, the tool applies the corresponding generation strategy.

### 5\. Java File Support

* Imports Java source files.
* Displays Java classes and methods in the GUI.
* Allows Java source code to be viewed together with the corresponding specification materials.

### 6\. Theorem-Based Testing Functions

The tool retains theorem-related functions from the original V-Method prototype.

* Theorem files can be imported.
* Test data can be generated from theorem assumptions.
* Generated data can be used to check whether the theorem conclusion holds.
* The result is displayed as `TRUE` or `FALSE`.

### 7\. Test-Case Management

* Displays generated variables and values in table form.
* Displays the distance associated with generated test data.
* Supports saving generated test cases.
* Allows imported files to be removed and replaced when a specification or source file is updated.

\---

## Installation

1. Extract the installation package to a local directory.
2. Run the executable or launcher included in the package.
3. Keep the example files included in the package available for initial testing.

The required Java runtime environment is bundled with the installation package. Users do not need to install Java separately before running the tool.

\---

## User Interface

The main interface contains the following areas:

* **SOFL Spec**  
Displays imported SOFL specifications, modules, processes, and associated FSF files.
* **Java File**  
Displays imported Java classes and methods.
* **Test Condition**  
Lists the test conditions derived from the selected Functional Scenario Form.
* **Atomic Predicate**  
Displays the atomic predicates contained in the selected Test Condition.
* **Theorem**  
Displays theorem-related information when theorem-based testing is used.
* **Test Case**  
Displays generated test data, including variables, values, distances, and available result information.
* **Preview / Source Code**  
Displays the selected specification or Java source file.
* **Setting**  
Opens the configuration interface for test-data generation.

\---

## Quick Start

### Step 1: Import a Java File

1. Click **Add Java File**.
2. Select a Java source file.
3. The imported class and its methods will appear in the **Java File** tree.

### Step 2: Add a Specification

1. Click **Add Specification**, or use the corresponding operation for the selected project/class.
2. Select the SOFL specification file.
3. Confirm that the module and process are displayed in the **SOFL Spec** tree.

### Step 3: Add the Functional Scenario Form

1. Select the target SOFL process.
2. Add or select the corresponding FSF file.
3. The tool extracts the functional scenarios and lists them as **Test Condition 1**, **Test Condition 2**, and so on.

### Step 4: Inspect Test Conditions and Atomic Predicates

1. Select a Test Condition.
2. The Atomic Predicates belonging to that condition are displayed in the **Atomic Predicate** pane.
3. You may generate test data either from the complete Test Condition or from an individual Atomic Predicate.

### Step 5: Configure Test-Data Generation

1. Click **Setting**.
2. Configure the required generation parameters, such as:

   * number of test cases;
   * distance;
   * distance increment.
3. Return to the main interface after saving the settings.

### Step 6: Generate Test Data from a Test Condition

1. Select the target Test Condition.
2. Click **Generate** above the Test Condition pane.
3. The generated test data are displayed in the **Test Case** table.

### Step 7: Generate Test Data from an Atomic Predicate

1. Select an Atomic Predicate.
2. Click **Generate** above the Atomic Predicate pane.
3. The generated data for the selected AP are displayed in the table.

### Step 8: Review the Generated Test Cases

The **Test Case** table normally includes:

* variable names;
* generated values;
* distance values;
* other available test information.

Review the generated data before saving or using them in subsequent testing activities.

### Step 9: Save Generated Test Cases

1. Click **Save**.
2. Select the output location.
3. Keep the saved test data together with the corresponding specification and generation settings if the experiment needs to be reproduced.

\---

## Theorem-Based Testing

The theorem-testing functions inherited from the original V-Method prototype can also be used.

### Step 1: Add a Theorem

1. Click **Add Theorem**.
2. Select the theorem file.

### Step 2: Generate Test Data

1. Select the theorem or its hypothesis.
2. Generate test data using the available generation function.

### Step 3: Verify the Theorem

1. Click **Verify**.
2. The tool evaluates the theorem using the generated test data.
3. A result of `TRUE` indicates that the conclusion holds for the tested data, while `FALSE` indicates a counterexample for the tested instance.

\---

## Recommended Workflow for First-Time Users

1. Start with the example projects included in the installation package.
2. Import the Java file.
3. Import the SOFL specification.
4. Add the corresponding FSF file.
5. Select a Test Condition and inspect its Atomic Predicates.
6. Open **Setting** and configure the test-generation parameters.
7. Generate test cases from a single AP first.
8. Generate test cases from the complete Test Condition.
9. Review the generated values and distances.
10. Save the test cases if required.
11. After confirming that the example works correctly, repeat the same process using your own specification.

\---

## Notes and Current Scope

The tool is a research prototype designed primarily for evaluating the Improved V-Method and specification-based test-data generation.

The current implementation supports a broad range of SOFL expressions, but some highly complex combinations may still require further extension. Examples include very deeply nested expressions or unusual combinations of multiple data abstractions.

When evaluating the tool, users are encouraged to keep the exact specification, FSF file, generation settings, and generated test cases so that results can be reproduced.

\---

## Example Files

The installation package includes example materials that can be used to test the tool, such as:

* Java source file;
* SOFL specification file;
* Functional Scenario Form file;
* theorem file.

It is recommended that first-time users run an included example before importing their own project.

\---

## Contact

For questions, bug reports, or further information, please contact the development team.

Email: **syliu@sei.ecnu.edu.cn**

