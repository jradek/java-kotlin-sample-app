# Running and debuging a mixed java/kotlin project with VS code

## TL;DR

Install fwcd.kotlin extension.

Many sites demostrate how to code and run Kotlin programs, without showing how to debug it.

*Disclaimer*: it is build upon this [repository](https://github.com/thunderz99/kt-sample-app)

## VSCode extensions

```console
mkdir -p .vscode
vi .vscode/extensions.json
```

Input the following code

```json
{
    "recommendations": [
        "fwcd.kotlin",
        "vscjava.vscode-java-pack"
    ]
}
```

and launch

```console
% code .
```

## Building

```console
gradle build
```

This creates a jar and collects all runtime dependencies in `build/libs`.
An "uberJar" containing all dependencies is built in `build/shadowJar`.

## Running

* java Main

    ```console
    java -cp "build/libs/*" kt.sample.app.Main
    ```

* kotlin Main

    ```console
    java -cp "build/libs/*" kt.sample.app.AppKt
    ```

## Debugging

Debug settings in `.vscode/lauch.json`

```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "kotlin",
            "request": "launch",
            "name": "Kotlin Launch",
            "projectRoot": "${workspaceFolder}",
            "mainClass": "kt/sample/app/AppKt",
            "preLaunchTask": "build"
        },
        {
            "type": "java",
            "request": "launch",
            "name": "Java Launch",
            "projectRoot": "${workspaceFolder}",
            "mainClass": "kt.sample.app.Main",
            "preLaunchTask": "build"
        }
    ]
}
```
