# FILL IN HEADER COMMENTS


import socket
import os.path

# Ask user for file name:
filename = raw_input("File to transfer: ")

try:
    # Open the file, get its size
    f = open(filename,'rb')
    filesize = os.path.getsize(filename)


    # Create socket and connect to the socket created by filerecv.py:
    #    ...
    sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    sock.connect(('',12345))


    # Send the PUT message
    #print "send the PUT message"
    sock.send("PUT "+filename+" "+str(filesize))
    #print "done sending PUT message"
    


    # Receive and print the "OK" message:
    #sock.listen(4)
    #connection, addr = sock.accept()
    #print "DEBUG: connected to "+str(addr)
    #connection.settimeout(1)
    okmess = sock.recv(1024)
    #print "DEBUG: we have recieved the ok message from guillaumerecv"
    print okmess
    #GOT THIS FAR IN OUTPUT!!!!
    


    # Loop: send the file in blocks of size 1024; after each send,
    # receive a reply from the server and print it.
    i = 0
    while i<=filesize:
      block = f.read(1024)
      i = i + len(block)
      # When we reach end of file, block is empty:
      if not block:
        print "file sent"
        break
      sock.send(block)
      checkMess = sock.recv(1024)
      print checkMess

    print "closing file "+filename
    f.close()
    # Receive and print final "OK Received...." message, close
    # file, close socket
    #    ...
    
    sock.close()
    print checkMess

except socket.error:
    print "socket error -- can't find server"

except IOError:
    print "no such file"
