# FILL IN HEADER COMMENTS

import socket

MAXFILES = 3 # receive at most this many files
MAXBLOCKS = 1000 # files can't exceed 1000 * 1024 bytes
SERVERTIMEOUT = 30 # after 30 seconds with no requests, shut down server

# Create a server socket that listens for files:
sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
sock.bind(('',12345))
sock.listen(1)
sock.settimeout(SERVERTIMEOUT)

try: # We handle a server socket timeout at the "except:" line

  for filenum in range(MAXFILES):
    
    connection,addr = sock.accept()
    print "DEBUG: connected to" + str(addr)
    print "DEBUG: " #only getting this far
   
    sock.send("OK")
    sock.listen(1)

    message = sock.accept()
    message.split()
    command = message[0]
    filename = message[1]
    filesize = int(message[2])
    print "DEBUG filename: "+ str(filename)
    print "DEBUG filesize: "+ str(filesize)
    connection.send('OK')
    
    # Create a new file:
    f = open('_'+filename,'wb')
    print "DEBUG: Saving "+filename+" in _"+filename

    try:
      print "inside try loop"
      # Loop to receive data and send back cumulative bytes received:
        #    ...

      # No more data--close file, send final OK message, and close connection
      #    ...

    except socket.timeout: # This shouldn't happen!
        print "DEBUG: connection timed out (this shouldn't happen!)"
        f.close()
        connection.close()

  sock.close() # Close after MAXFILES files have been received

except socket.timeout:
  print "DEBUG: listener timed out"
  sock.close()
