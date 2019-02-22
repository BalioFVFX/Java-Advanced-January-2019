# Problem 1.
# Problem 1 – Hospital

Your task will be to prepare an electronic register for a hospital. In the hospital we have different departments:

- Cardiology
- [Oncology](https://en.wikipedia.org/wiki/Oncology)
- [Emergency department](https://en.wikipedia.org/wiki/Emergency_department)
-

Each department has **20** rooms for patients and **each room**** has 3 beds **. When a new patient goes in the hospital, he/she is placed on the first free bed in the department. If there are no free beds, the patient should go in another hospital. Of course, in every hospital there are doctors. Each doctor can have patients in a different department. You will receive information about patients in the format** {Department} {Doctor} {Patient}**

After the &quot;Output&quot; command you will receive some other commands with what kind of output you need to print. The commands are:

- **{Department}** – You need to **print all patients** in this department in the **order of receiving**
- **{Department} {Room}** – You need to **print all patients** in this room in **alphabetical order**
- **{Doctor}** – you need to **print all patients** for this doctor in **alphabetical order**

The program ends when you receive command &quot;End&quot;.

### **Input**

On the first lines you will receive info for the hospital, department, doctors and patients in the following format:

**{Department} {Doctor} {Patient}**

When you read the &quot; **Output**&quot; line you will get one or more commands telling you what you need to print

Read commands for printing, &#39;till you reach the command &quot; **End**&quot;

### **Output**

- **{Department}** – print all patients in this department in order of receiving on new line
- **{Department} {Room}** – print all patients in this room in alphabetical order each on new line
- **{Doctor}** – print all patients that are healed from doctor in alphabetical order on new line

### **Constraints**

- **{Department}** – single word with length **1 \&lt; n \&lt; 100**
- **{Doctor}** – name and surname, both with length **1 \&lt; n \&lt; 20**
- **{Patient}** – unique name with length **1 \&lt; n \&lt; 20**
- **{Room}** – integer **1 \&lt;= n \&lt;= 20**
- Time limit: 0.3 sec. Memory limit: 16 MB.

### **Examples**

| **Input** | **Output** |
| --- | --- |
| Cardiology Petar Petrov VentsiOncology Ivaylo Kenov ValioEmergency Mariq Mircheva SimoCardiology Genka Shikerova SimonEmergency Ivaylo Kenov NuPogodiCardiology Gosho Goshov EsmeraldaOncology Gosho Goshov CleopatraOutputCardiologyEnd | VentsiSimonEsmeralda |

| **Input** | **Output** |
| --- | --- |
| Cardiology Petar Petrov VentsiOncology Ivaylo Kenov ValioEmergency Mariq Mircheva SimoCardiology Genka Shikerova SimonEmergency Ivaylo Kenov NuPogodiCardiology Gosho Goshov EsmeraldaOncology Gosho Goshov CleopatraOutputCardiology 1End | EsmeraldaSimonVentsi |

| **Input** | **Output** |
| --- | --- |
| Cardiology Petar Petrov VentsiOncology Ivaylo Kenov ValioEmergency Mariq Mircheva SimoCardiology Genka Shikerova SimonEmergency Ivaylo Kenov NuPogodiCardiology Gosho Goshov EsmeraldaOncology Gosho Goshov CleopatraOutputIvaylo Kenov End | NuPogodiValio |