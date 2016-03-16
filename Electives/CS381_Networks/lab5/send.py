# Very simple file transfer client. No protocol, just "dump" the
# file into the socket.

import socket
import time # for testing purposes--used to force server timeout
import os.path

# Ask user for file name:
filename = raw_input("File to transfer: ")

try:
    f = open(filename,'rb')
    filesize = os.path.getsize(filename)
    # Connect to the server:
    sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    sock.connect(('',12345))
    sock.send("PUT "+filename+" "+str(filesize))
    
  
    sock.listen(10)
    message = sock.accept()
    print "is it ok?: " + message
    #except socket.error:
    #  print "socket error, cannot recieve okay message"


    while True:
      block = f.read(1024)

      # When we reach end of file, block is empty:
      if not block:
        print "file sent"
        break
      sock.send(block)

    print "closing file "+filename
    f.close()

    # Next line is for testing server timeout:
    #time.sleep(3)

    sock.close()
except socket.error:
    print "socket error -- can't find server"

except IOError:
    print "no such file"
