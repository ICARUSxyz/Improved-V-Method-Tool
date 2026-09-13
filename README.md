# Improved V-Method and Its Tool Support for Specification-Based Testing

## Overview

This repository contains the research artifacts for the paper **“Improved V-Method and Its Tool Support for Specification-Based Testing.”**

The project provides the experimental data, evaluation results, and tool support used to study the Improved V-Method for specification-based testing. The accompanying research prototype processes SOFL formal specifications and generates test data from formal test conditions using the Vibration Method.

## Repository Structure

```text
.
├── Appendices/
│   └── Appendices.pdf              # Appendices of the paper
├── Data/
│   ├── Experiment1/
│   │   ├── Codes/
│   │   │   ├── openSourceCode/     # Open-source Java programs
│   │   │   └── studentCode/        # Student Java programs
│   │   ├── FSFs/                   # Functional Scenario Form files
│   │   ├── Specifications/         # SOFL specification files
│   │   └── ComplexityCharacteristics.xlsx
│   └── Experiment2/
│       └── ComplexityCharacteristics.xlsx
├── Result/
│   ├── Experiment1/
│   │   ├── Reports/                # Detailed experiment report 
│   │   └── result.xlsx             # Experiment 1 results
│   └── Experiment2/
│       └── result.xlsx             # Experiment 2 results
├── Tool/
│   ├── Example/
│   │   ├── Buy_Ticket_FSF.txt      # Example Functional Scenario Form
│   │   ├── Ticket System_Spec.txt  # Example SOFL specification
│   │   ├── TicketSystem.java       # Example Java source file
│   │   └── theorem.txt             # Example theorem
│   ├── Install/
│   │   └── ImprovedVMethodTool_Setup.exe
│   └── README.md                   # Complete tool documentation
└── README.md
```

## Tool Installation

The installation package is provided in `Tool/Install/`.

1. Download or clone this repository.
2. Run `Tool/Install/ImprovedVMethodTool_Setup.exe`.
3. Follow the installer instructions.

The required Java runtime environment is bundled with the installation package, so a separate Java installation is not required.

## Quick Start

The files under `Tool/Example/` can be used to explore the complete workflow.

1. Start the Improved V-Method Testing Tool.
2. Import `Tool/Example/TicketSystem.java` using **Add Java File**.
3. Import `Tool/Example/Ticket System_Spec.txt` using **Add Specification**.
4. Select the relevant SOFL process and add `Tool/Example/Buy_Ticket_FSF.txt`.
5. Select a test condition and inspect its atomic predicates.
6. Open **Setting** and configure parameters such as the number of test cases, vibration distance, and distance increment.
7. Select a test condition or atomic predicate and click **Generate**.
8. Review the generated values and their distances in the **Test Case** table, then save them if required.

The tool also supports theorem-based testing with `Tool/Example/theorem.txt`: import the theorem, generate test data from its assumptions, and use **Verify** to evaluate its conclusion for the generated data.

For the complete feature overview, detailed interface description, supported expression categories, and step-by-step usage instructions, see [Tool/README.md](Tool/README.md).

## Contact

For questions, bug reports, or further information, please contact the development team at **syliu@sei.ecnu.edu.cn**.
