import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    const appTitle = 'Log in into your account';

    return MaterialApp(
      title: appTitle,
      home: Scaffold(
        appBar: AppBar(
          title: const Text(appTitle),
        ),
        body: const MyCustomForm(),
      ),
    );
  }
}

class MyCustomForm extends StatefulWidget {
  const MyCustomForm({super.key}) ;

  @override
  State<MyCustomForm> createState() {
    return MyCustomFormState();
  }
}

class _MyCustomFormState extends State<MyCustomForm> {
  @override
  Widget build(BuildContext context) {
    return Container();
  }
}

class SecondRoute extends StatelessWidget {
  const SecondRoute({super.key}) ;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Electronics Store'),
      ),
      body: ListView(
        padding: EdgeInsets.zero,
        children: [
          const DrawerHeader(
            decoration: BoxDecoration(color: Colors.blueGrey,
            ),
            child: Text('Electronic Devices', textScaleFactor: 3, textAlign: TextAlign.left,),
          ),
          ListTile(
            title: const Text('Laptops'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Smart Phones'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Desktops'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Accessories'),
            onTap: () {
            //  Navigator.pop(context);
            },
          ),
          ListTile(
            title: const Text('Speakers'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Printers'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Monitors'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Keyboards'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Mouse'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Cables'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Pen Drives'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Hard Disk Drives'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('SSDs'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Gaming PCs'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Gaming Laptops'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Consoles'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
          ListTile(
            title: const Text('Television'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Processing Data')
                  )
              );
            },
          ),
        ],
      ),
      drawer: Drawer(
        child: ElevatedButton(
          onPressed: () {
            Navigator.push(context, MaterialPageRoute(builder: (context) => const MyApp()));

          },
          child: const Text('Sign Out'),
        ),
      ),
    );
  }
}


class MyCustomFormState extends State<MyCustomForm> {
  final _formkey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {

    return Form(
      key: _formkey,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          TextFormField(
            validator: (value) {
              if (value == null || value.isEmpty) {
                return 'Please enter your username';
              }
              return null;
            },
          ),
          Padding(
            padding: const EdgeInsets.symmetric(vertical: 16.0),
            child: ElevatedButton(
              onPressed: () {
                if (_formkey.currentState!.validate()){
                  ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(content: Text('Processing')),
                      );
                    Navigator.push(context, MaterialPageRoute(builder: (context) => const SecondRoute()),
                  );
                }
              },
              child: const Text('Sign in'),
            ),
          ),
        ],
      ),
    );
  }
}
